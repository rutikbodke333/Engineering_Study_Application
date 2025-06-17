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

//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "user_id")
//	
//	private User user;

}
