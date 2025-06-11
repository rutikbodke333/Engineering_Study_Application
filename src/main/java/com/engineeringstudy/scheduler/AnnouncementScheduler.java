package com.engineeringstudy.scheduler;

import com.engineeringstudy.entity.Announcement;
import com.engineeringstudy.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementScheduler {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Scheduled(cron = "0 0 0 * * *") // run every day at midnight  
//  the method will run every day at midnight (00:00:00) and check announcemnt create before 7 days 
//   and delete them if they are expired.
    public void deleteExpiredAnnouncements() {
        LocalDateTime now = LocalDateTime.now();
        
        List<Announcement> expired = announcementRepository.findAll()
            .stream()
            .filter(a -> a.getExpiryDate() != null && a.getExpiryDate().isBefore(now))
            .collect(Collectors.toList()); 
               

        announcementRepository.deleteAll(expired);
    }
}



//1. announcementRepository.findAll()

//This will get all announcements from your database (like the table above) and give them to Java as a list:
//	List<Announcement> all = List.of(
//		    new Announcement(1, "Exam Timetable", ..., expiryDate = 2025-06-05),
//		    new Announcement(2, "Holiday Announcement", ..., expiryDate = 2025-06-08),
//		    new Announcement(3, "Orientation Info", ..., expiryDate = 2025-06-10),
//		    new Announcement(4, "Exam Results", ..., expiryDate = null)
//		);

//--------------------------------------------------------------------------------------------------------------------------


//🔹 2. .stream().filter(...)

//This part loops through all announcements one by one and keeps only expired ones.
//.filter(a -> 
//    a.getExpiryDate() != null && // check expiry date exists
//    a.getExpiryDate().isBefore(now) // check it’s before today
//)
//
//For today's date 2025-06-09:

//Announcement	         Expiry Date	   Condition Met?
//Exam Timetable	         2025-06-05	       ✅ Yes
//Holiday Announcement	 2025-06-08	       ✅ Yes
//Orientation Info	     2025-06-10	       ❌ No (future)
//Exam Results	         null	           ❌ No (no date)

//So only 2 announcements are selected:
//ID 1: Exam Timetable
//ID 2: Holiday Announcement

//List<Announcement> expired = List.of(announcement1, announcement2);


//3. announcementRepository.deleteAll(expired);
//
//This will take the expired list and delete them from the database.
//
//DELETE FROM announcements WHERE id IN (1, 2);

