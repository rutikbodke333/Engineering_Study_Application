package com.engineeringstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engineeringstudy.entity.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

}
