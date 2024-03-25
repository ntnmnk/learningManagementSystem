package com.learning.learningmanagementsystem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.learningmanagementsystem.models.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
