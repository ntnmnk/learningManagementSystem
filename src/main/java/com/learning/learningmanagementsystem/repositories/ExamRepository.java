package com.learning.learningmanagementsystem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.learning.learningmanagementsystem.models.Exam;
@RepositoryRestResource(collectionResourceRel = "Exam", path = "exams")

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
