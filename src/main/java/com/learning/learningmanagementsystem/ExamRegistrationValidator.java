package com.learning.learningmanagementsystem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.stereotype.Component;

import com.learning.learningmanagementsystem.models.Exam;
import com.learning.learningmanagementsystem.models.Student;
import com.learning.learningmanagementsystem.models.Subject;
import com.learning.learningmanagementsystem.repositories.ExamRepository;
import com.learning.learningmanagementsystem.repositories.StudentRepository;
import com.learning.learningmanagementsystem.repositories.SubjectRepository;

@Component
public class ExamRegistrationValidator {
    @Autowired
    private StudentRepository studentRepository;

    public boolean validateRegistration(Long studentId, Long examId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (!studentOptional.isPresent()) {
            return false; // Student not found
        }

        Student student = studentOptional.get();
        Optional<Exam> examOptional = student.getSubjects().stream()
                .flatMap(subject -> subject.getExams().stream()
                        .filter(e -> e.getId().equals(examId)))
                .findFirst();

        return examOptional.isPresent();  // Check if exam belongs to a subject student is enrolled in
    }
}




