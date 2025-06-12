package com.engineeringstudy.service;

import com.engineeringstudy.dto.DocumentDto;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public interface DocumentService {
	DocumentDto uploadDocument(MultipartFile file, DocumentDto dto) throws IOException;

	DocumentDto getDocumentById(Long id);

	List<DocumentDto> getAllDocuments();
}
