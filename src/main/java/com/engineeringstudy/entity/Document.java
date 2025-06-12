package com.engineeringstudy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documents")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title; // e.g., "Timetable Sem 3", "Result CE22A123", etc.
	private String documentType; // e.g., "RESULT", "TIMETABLE", "EBOOK", "Question-PAPER"

	private String branch; // Optional: e.g., "Computer", "IT"
	private String semester; // Optional: e.g., "Semester 4"
	private String academicYear; // Optional: e.g., "2024-2025"
	private String department;
	
	private String filePath; // Saved file location
}
