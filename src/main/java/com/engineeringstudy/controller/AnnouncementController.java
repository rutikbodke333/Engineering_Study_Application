package com.engineeringstudy.controller;

import com.engineeringstudy.dto.AnnouncementDto;
import com.engineeringstudy.entity.PaginationResponce;
import com.engineeringstudy.service.AnnouncementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/engineeringstudy/admin/announcements")
public class AnnouncementController {

	@Autowired
	private AnnouncementService announcementService;

	// Create new announcement (admin only)
	@PostMapping
	public ResponseEntity<AnnouncementDto> createAnnouncement(@Valid @RequestBody AnnouncementDto announcementDto) {
		AnnouncementDto newAnnouncement = announcementService.createAnnouncement(announcementDto);
		return new ResponseEntity<>(newAnnouncement, HttpStatus.CREATED);
	}

	// Update announcement by announcementId
	@PutMapping("/{announcementId}")
	public ResponseEntity<AnnouncementDto> updateAnnouncement(@Valid @RequestBody AnnouncementDto announcementDto,
			@PathVariable Long announcementId) {
		AnnouncementDto updated = announcementService.updateAnnouncement(announcementDto, announcementId);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}

	// Get all announcements
	@GetMapping
	public ResponseEntity<PaginationResponce> getAllAnnouncements(@RequestParam(defaultValue = "0") Integer pageNumber,
			@RequestParam(defaultValue = "4") Integer pageSize, @RequestParam(defaultValue = "title") String sortBy,
			@RequestParam(defaultValue = "asc") String sortDir) {
		PaginationResponce paginationResponse = announcementService.getAll(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(paginationResponse, HttpStatus.OK);
	}

	// Get announcement by ID
	@GetMapping("/{announcementId}")
	public ResponseEntity<AnnouncementDto> getById(@PathVariable Long announcementId) {
		AnnouncementDto announcement = announcementService.getById(announcementId);
		return new ResponseEntity<>(announcement, HttpStatus.OK);
	}
}
