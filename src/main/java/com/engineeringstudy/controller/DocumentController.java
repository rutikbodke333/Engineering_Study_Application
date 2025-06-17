package com.engineeringstudy.controller;

import com.engineeringstudy.dto.DocumentDto;
import com.engineeringstudy.entity.PaginationResponce;
import com.engineeringstudy.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/engineeringstudy/user/documents")
public class DocumentController {

	@Autowired
	private DocumentService documentService;

//  upload documnet based on userId
	@PostMapping("/upload/{userId}")
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

	@GetMapping("/{id}")
	public ResponseEntity<DocumentDto> getDocumentById(@PathVariable Long id) {
		DocumentDto document = documentService.getDocumentById(id);
		return ResponseEntity.ok(document);
	}

	@GetMapping
	public ResponseEntity<PaginationResponce> getAllDocuments(@RequestParam(defaultValue = "0") Integer pageNumber,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "title") String sortBy,
			@RequestParam(defaultValue = "asc") String sortDir) {

		PaginationResponce paginationResponse = documentService.getAllDocuments(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(paginationResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDocument(@PathVariable Long id) {
		documentService.deleteDocument(id);
		return new ResponseEntity<>("Document deleted successfully", HttpStatus.OK);
	}
}
