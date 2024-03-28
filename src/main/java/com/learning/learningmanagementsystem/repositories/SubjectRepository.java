package com.learning.learningmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.learning.learningmanagementsystem.models.Subject;
@RepositoryRestResource( path = "subjects")

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findBySubjectId(@Param("subjectId") String subjectId);
}
