package com.engineeringstudy.service;

import com.engineeringstudy.dto.DocumentDto;
import com.engineeringstudy.entity.Document;
import com.engineeringstudy.entity.PaginationResponce;
import com.engineeringstudy.entity.User;
import com.engineeringstudy.repository.DocumentRepository;
import com.engineeringstudy.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImple implements DocumentService {

	@Value("${location}")
	private String uploadDir;

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DocumentDto uploadDocument(MultipartFile file, DocumentDto dto, Long userId) throws IOException {

		User id = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

		Files.createDirectories(Paths.get(uploadDir));

		String filename = file.getOriginalFilename();

		Path path = Paths.get(uploadDir, filename);

		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

		Document document = modelMapper.map(dto, Document.class);

//		This line sets the path where the file was saved, so we can store it in the database.
		document.setFilePath(path.toString());
		document.setUser(id);
		document.setTitle(filename);

		Document savedDocument = documentRepository.save(document);

		return modelMapper.map(savedDocument, DocumentDto.class);
	}

	@Override
	public DocumentDto getDocumentById(Long id) {
		Document doc = documentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Document not found with ID: " + id));
		return modelMapper.map(doc, DocumentDto.class);
	}

	@Override
	public PaginationResponce getAllDocuments(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

		Sort sort = null;
		if (sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		} else {
			sort = Sort.by(sortBy).descending();
		}

		Pageable pageable = PageRequest.of(pageNumber, pageSize);

		Page<Document> documentPage = documentRepository.findAll(pageable);
		List<Document> listOfDocuments = documentPage.getContent();
		// Convert list of Document entities to list of DocumentDto

		List<DocumentDto> listOfDocumentDtos = listOfDocuments.stream()
				.map(doc -> modelMapper.map(doc, DocumentDto.class)).collect(Collectors.toList());
		PaginationResponce paginationResponse = new PaginationResponce();
		paginationResponse.setContent(listOfDocumentDtos);
		paginationResponse.setPageNumber(documentPage.getNumber());
		paginationResponse.setPageSize(documentPage.getSize());
		paginationResponse.setTotalElements(documentPage.getTotalElements());
		paginationResponse.setTotalPages(documentPage.getTotalPages());
		paginationResponse.setLastPage(documentPage.isLast());

		return paginationResponse;
	}

	@Override
	public void deleteDocument(Long id) {
		Document document = documentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Document not found with ID: " + id));

		// Step 1: Delete the file from the folder
		String filePath = document.getFilePath(); // or construct from baseDir + fileName
		File file = new File(filePath);
		if (file.exists()) {
			boolean deleted = file.delete();
			if (!deleted) {
				throw new RuntimeException("Failed to delete file from disk");
			}
		}

		// Step 2: Delete record from the database
		documentRepository.deleteById(id);
	}

}
