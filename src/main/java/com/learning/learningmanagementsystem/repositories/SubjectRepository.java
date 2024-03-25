package com.learning.learningmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.learningmanagementsystem.models.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
