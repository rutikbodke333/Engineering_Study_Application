package com.engineeringstudy.controller;

import com.engineeringstudy.dto.DocumentDto;
import com.engineeringstudy.entity.PaginationResponce;
import com.engineeringstudy.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	
	@PostMapping("user/{userId}/documents/upload")
	public ResponseEntity<DocumentDto> uploadDocument(@RequestParam("file") MultipartFile file,
			@RequestParam("documentType") String documentType, @RequestParam("branch") String branch,
			@RequestParam("semester") String semester, @RequestParam("academicYear") String academicYear,
			@RequestParam("department") String department, @PathVariable Long userId) throws IOException {
		DocumentDto dto = new DocumentDto();
		dto.setDocumentType(documentType);
		dto.setBranch(branch);
		dto.setSemester(semester);
		dto.setAcademicYear(academicYear);
		dto.setDepartment(department);

		DocumentDto saved = documentService.uploadDocument(file, dto, userId);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	
	@GetMapping("/documents/{id}")
	public ResponseEntity<DocumentDto> getDocumentById(@PathVariable Long id) {
		
		DocumentDto document = documentService.getDocumentById(id);
		return ResponseEntity.ok(document);
	}


	@GetMapping("/documents")
	public ResponseEntity<PaginationResponce> getAllDocuments(
			@RequestParam(value = "pageNumber", defaultValue = "2") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "title") String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc") String sortDir

	) {

		PaginationResponce paginationResponse = documentService.getAllDocuments(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(paginationResponse, HttpStatus.OK);
	}
}
