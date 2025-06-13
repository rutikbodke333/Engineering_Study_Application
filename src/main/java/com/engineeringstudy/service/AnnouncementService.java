package com.engineeringstudy.service;

import com.engineeringstudy.dto.AnnouncementDto;

import java.util.List;

public interface AnnouncementService {

	// Create or update an announcement
	AnnouncementDto upsertAnnouncemen(AnnouncementDto announcementDto, Long id);

	// Fetch all announcements
	List<AnnouncementDto> getAll();

	// Get announcement by ID
	AnnouncementDto getById(Long id);

	// Delete announcement by ID
	void deleteById(Long id);
}
