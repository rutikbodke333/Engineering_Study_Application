package com.engineeringstudy.repository;

import com.engineeringstudy.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
   
}
