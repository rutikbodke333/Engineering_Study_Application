package com.engineeringstudy.dto;

import com.engineeringstudy.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto {

    private Long id;
    private String title;
    private String documentType;  // e.g., "RESULT", "TIMETABLE", "EBOOK", "PAPER"
    private String branch;        // Optional: "Computer Engineering"
    private String semester;      // Optional: "Semester 5"
    private String academicYear;          // Optional: "2024-2025"
    private String department; 	// Optional: "Computer Science and Engineering"
    private String filePath;      // Path to the uploaded file
    private UserDto user;
}
