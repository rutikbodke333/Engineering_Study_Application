package com.engineeringstudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.engineeringstudy.dto.AnnouncementDto;
import com.engineeringstudy.service.AnnouncementService;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    // Create new announcement
    @PostMapping("/create")
    public ResponseEntity<AnnouncementDto> createAnnouncement(@RequestBody AnnouncementDto announcementDto) {
        AnnouncementDto newAnnouncement = announcementService.upsertAnnouncemen(announcementDto);
        return new ResponseEntity<>(newAnnouncement, HttpStatus.CREATED);
    }

    // Update announcement
    @PutMapping("/update")
    public ResponseEntity<AnnouncementDto> updateAnnouncement(@RequestBody AnnouncementDto announcementDto) {
        AnnouncementDto updatedAnnouncement = announcementService.upsertAnnouncemen(announcementDto);
        return new ResponseEntity<>(updatedAnnouncement, HttpStatus.OK);
    }

    // Get all announcements
    @GetMapping("/")
    public ResponseEntity<List<AnnouncementDto>> getAllAnnouncements() {
        List<AnnouncementDto> announcements = announcementService.getAll();
        return new ResponseEntity<>(announcements, HttpStatus.OK);
    }

    // Get announcement by ID
    @GetMapping("/{announcementId}")
    public ResponseEntity<AnnouncementDto> getAnnouncementById(@PathVariable Long announcementId) {
        AnnouncementDto announcement = announcementService.getById(announcementId);
        return new ResponseEntity<>(announcement, HttpStatus.OK);
    }
}
