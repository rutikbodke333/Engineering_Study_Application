package com.engineeringstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDto {

	private Long id;
	private String title;
	private String content;
	private String createdBy;
	private String targetAudience;
	private LocalDateTime createdAt;
	private LocalDateTime expiryDate;
}

//{
//"title": "Semester VII Timetable Released",
//"content": "The official timetable for Semester VII (Computer Engineering) has been released. Classes will begin on Monday, July 8th, 2025. Please check your department notice board or the Student Portal for the detailed schedule.\n\nHighlights:\n- Theory lectures: Monday to Friday (9:00 AM – 4:00 PM)\n- Lab sessions: Tuesday & Thursday afternoons\n- Electives: Friday (2:00 PM – 4:00 PM)\n\nEnsure you attend the orientation session on July 7th at 10:00 AM in Room C301.",
//"createdBy": "Department of Computer Engineering",
//"targetAudience": "Comps Sem VII"
//}