package com.engineeringstudy.service;

import com.engineeringstudy.dto.AnnouncementDto;
import com.engineeringstudy.entity.Announcement;
import com.engineeringstudy.entity.User;
import com.engineeringstudy.repository.AnnouncementRepository;
import com.engineeringstudy.repository.UserRepository;
import com.engineeringstudy.service.AnnouncementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

	@Autowired
	private AnnouncementRepository announcementRepository;
	
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

//    create and update the announcement
	@Override
	public AnnouncementDto upsertAnnouncemen(AnnouncementDto dto, Long userId) {
		
		User id = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
		Announcement announcement = modelMapper.map(dto, Announcement.class);
		announcement.setCreatedAt(LocalDateTime.now()); // Now: 2025-06-09 10:15 AM
//      2025-06-09 10:15 AM + 1 week(7 days)  = 2025-06-16 10:15 AM
		announcement.setExpiryDate(LocalDateTime.now().plusWeeks(1));
		announcement.setUser(id);

		Announcement saved = announcementRepository.save(announcement);
		return modelMapper.map(saved, AnnouncementDto.class);
	}

//    Fetch all announcements
	@Override
	public List<AnnouncementDto> getAll() {
		List<Announcement> announcements = announcementRepository.findAll();
		List<AnnouncementDto> announcementDtos = announcements.stream()
				.map(a -> modelMapper.map(a, AnnouncementDto.class)).collect(Collectors.toList());
		return announcementDtos;
	}

//    Get announcement by ID
	@Override
	public AnnouncementDto getById(Long id) {
		Announcement announcement = announcementRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Announcement not found with id: " + id));
		return modelMapper.map(announcement, AnnouncementDto.class);
	}

//    Delete announcement by ID
	@Override
	public void deleteById(Long id) {
		announcementRepository.deleteById(id);
	}
}
