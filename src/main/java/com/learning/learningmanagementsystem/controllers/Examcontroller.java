package com.learning.learningmanagementsystem.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.learningmanagementsystem.models.Exam;
import com.learning.learningmanagementsystem.models.Student;
import com.learning.learningmanagementsystem.repositories.ExamRepository;
import com.learning.learningmanagementsystem.repositories.StudentRepository;

@RepositoryRestController
public class Examcontroller {
     @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/exams/{examId}/register")
    public ResponseEntity<String> registerStudentForExam(@PathVariable Long examId, @RequestBody Student student) {
        
        Optional<Exam> optionalExam = examRepository.findById(examId);
        if (!optionalExam.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exam not found with ID: " + examId);
        }
        Exam exam = optionalExam.get();

        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if (!optionalStudent.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with ID: " + student.getId());
        }
        student = optionalStudent.get();

        if (exam.getStudents().contains(student)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student is already registered for the exam.");
        }

        exam.getStudents().add(student);
        examRepository.save(exam);

        return ResponseEntity.status(HttpStatus.CREATED).body("Student registered successfully for the exam.");

    }

}
