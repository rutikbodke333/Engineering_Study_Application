package com.engineeringstudy.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "announcements")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    
    private String content;

    private String createdBy;

    private String targetAudience; // e.g., "All", "Mechanical", "Year 1"

    private LocalDateTime createdAt;

    private LocalDateTime expiryDate;

    
}



//{
//	  "title": "Semester VII Timetable Released",
//	  "content": "The official timetable for Semester VII (Computer Engineering) has been released. Classes will begin on Monday, July 8th, 2025. Please check your department notice board or the Student Portal for the detailed schedule.\n\nHighlights:\n- Theory lectures: Monday to Friday (9:00 AM – 4:00 PM)\n- Lab sessions: Tuesday & Thursday afternoons\n- Electives: Friday (2:00 PM – 4:00 PM)\n\nEnsure you attend the orientation session on July 7th at 10:00 AM in Room C301.",
//	  "createdBy": "Department of Computer Engineering",
//	  "targetAudience": "Comps Sem VII"
//	}
