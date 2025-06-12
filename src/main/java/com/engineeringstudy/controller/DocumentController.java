package com.engineeringstudy.controller;

import com.engineeringstudy.dto.DocumentDto;
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

	// ✅ Upload document using @RequestParam
	@PostMapping("/documents/upload")
	public ResponseEntity<DocumentDto> uploadDocument(@RequestParam("file") MultipartFile file,
			@RequestParam("title") String title, @RequestParam("documentType") String documentType,
			@RequestParam("branch") String branch, @RequestParam("semester") String semester,
			@RequestParam("academicYear") String academicYear, @RequestParam("department") String department)
			throws IOException {
		DocumentDto dto = new DocumentDto();
		dto.setTitle(title);
		dto.setDocumentType(documentType);
		dto.setBranch(branch);
		dto.setSemester(semester);
		dto.setAcademicYear(academicYear);
		dto.setDepartment(department);

		DocumentDto saved = documentService.uploadDocument(file, dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	// ✅ Get document metadata by ID
	@GetMapping("/documents/{id}")
	public ResponseEntity<DocumentDto> getDocumentById(@PathVariable Long id) {
		return ResponseEntity.ok(documentService.getDocumentById(id));
	}

	// ✅ Get all document metadata
	@GetMapping("/documents")
	public ResponseEntity<List<DocumentDto>> getAllDocuments() {

		List<DocumentDto> documents = documentService.getAllDocuments();
		return ResponseEntity.ok(documents);
	}
}
