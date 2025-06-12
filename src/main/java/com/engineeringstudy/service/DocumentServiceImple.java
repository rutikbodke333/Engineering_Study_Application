package com.engineeringstudy.service;

import com.engineeringstudy.dto.DocumentDto;
import com.engineeringstudy.entity.Document;
import com.engineeringstudy.exception.DocumentNotFoundException;
import com.engineeringstudy.repository.DocumentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	private ModelMapper modelMapper;

	@Override
	public DocumentDto uploadDocument(MultipartFile file, DocumentDto dto) throws IOException {

		Files.createDirectories(Paths.get(uploadDir));

		String filename = file.getOriginalFilename();

		Path path = Paths.get(uploadDir, filename);

		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

		Document document = modelMapper.map(dto, Document.class);
		
//		This line sets the path where the file was saved, so we can store it in the database.
		document.setFilePath(path.toString());
		
		Document savedDocument = documentRepository.save(document);

		return modelMapper.map(savedDocument, DocumentDto.class);
	}

	@Override
	public DocumentDto getDocumentById(Long id) {
		Document doc = documentRepository.findById(id)
				.orElseThrow(() -> new DocumentNotFoundException("Document not found with ID: " + id));
		return modelMapper.map(doc, DocumentDto.class);
	}

	@Override
	public List<DocumentDto> getAllDocuments() {

	    List<Document> listOfDocuments = documentRepository.findAll();

	    List<DocumentDto> listOfDocumentDtos = listOfDocuments.stream()
	            .map(doc -> modelMapper.map(doc, DocumentDto.class))
	            .collect(Collectors.toList());

	    return listOfDocumentDtos;
	}

}
