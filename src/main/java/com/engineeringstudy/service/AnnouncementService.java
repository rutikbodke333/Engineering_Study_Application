package com.engineeringstudy.service;

import com.engineeringstudy.dto.AnnouncementDto;

import java.util.List;

public interface AnnouncementService {
	
	AnnouncementDto upsertAnnouncemen(AnnouncementDto announcementDto);
	List<AnnouncementDto> getAll();
	AnnouncementDto getById(Long id);
	void deleteById(Long id);

}
