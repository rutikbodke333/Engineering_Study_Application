package com.engineeringstudy.service;

import com.engineeringstudy.dto.DocumentDto;
import com.engineeringstudy.entity.PaginationResponce;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface DocumentService {
	DocumentDto uploadDocument(MultipartFile file, DocumentDto dto, Long userId) throws IOException;

	DocumentDto getDocumentById(Long id);

	PaginationResponce getAllDocuments(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	public void deleteDocument(Long id);
}
//