package com.learning.learningmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import com.learning.learningmanagementsystem.models.Exam;
import com.learning.learningmanagementsystem.models.Student;
import com.learning.learningmanagementsystem.repositories.ExamRepository;
import com.learning.learningmanagementsystem.repositories.StudentRepository;

@Component
@RepositoryEventHandler
public class ExamRepositoryListener {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamRepository examRepository;

    @HandleBeforeSave
    public void validateStudentEnrollment(Exam exam) {
        Long studentId = exam.getEnrolledStudents().stream()
                .findFirst()
                .map(Student::getId)
                .orElseThrow(() -> new IllegalStateException("Exam has no enrolled students"));

        Long subjectId = exam.getSubject().getId();

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));

        // Validate that the student is enrolled in the corresponding subject of the exam
        if (!student.getSubjects().stream().anyMatch(subject -> subject.getId().equals(subjectId))) {
            throw new IllegalStateException("Student is not enrolled in the corresponding subject for the exam");
        }
    }
}


