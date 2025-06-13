package com.engineeringstudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.engineeringstudy.dto.AnnouncementDto;
import com.engineeringstudy.service.AnnouncementService;

@RestController
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    // Create new announcement
    @PostMapping("/user/{userId}/announcements")
    public ResponseEntity<AnnouncementDto> createAnnouncement(@RequestBody AnnouncementDto announcementDto, @PathVariable Long userId) {
        AnnouncementDto newAnnouncement = announcementService.upsertAnnouncemen(announcementDto, userId);
        return new ResponseEntity<>(newAnnouncement, HttpStatus.CREATED);
    }

    // Update announcement
    @PutMapping("/user/{userId}/announcements")
    public ResponseEntity<AnnouncementDto> updateAnnouncement(@RequestBody AnnouncementDto announcementDto, @PathVariable Long userId) {
        AnnouncementDto updatedAnnouncement = announcementService.upsertAnnouncemen(announcementDto, userId);
        return new ResponseEntity<>(updatedAnnouncement, HttpStatus.OK);
    }

    // Get all announcements
    @GetMapping("/")
    public ResponseEntity<List<AnnouncementDto>> getAllAnnouncements() {
        List<AnnouncementDto> announcements = announcementService.getAll();
        return new ResponseEntity<>(announcements, HttpStatus.OK);
    }

    // Get announcement by id
    @GetMapping("/{announcementId}")
    public ResponseEntity<AnnouncementDto> getAnnouncementById(@PathVariable Long announcementId) {
        AnnouncementDto announcement = announcementService.getById(announcementId);
        return new ResponseEntity<>(announcement, HttpStatus.OK);
    }
}
