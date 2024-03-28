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
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamRepository examRepository;

    @HandleBeforeCreate
    @HandleBeforeSave
    public void validateExamRegistration(Exam exam) {
        // Retrieve the subject associated with the exam
        Subject subject = exam.getSubject();
        if (subject == null) {
            throw new IllegalStateException("Exam must be associated with a subject");
        }

        // Retrieve the students enrolled in the subject
       // List<Student> enrolledStudents = student.getEnrolledStudents();

        // Retrieve the students enrolling for the exam
        List<Student> registeredStudentsForExam = exam.getEnrolledStudents();

        // Check if each student enrolling for the exam is already enrolled in the corresponding subject
        // for (Student student : registeredStudentsForExam) {
        //     if (!enrolledStudents.contains(student)) {
        //         throw new IllegalStateException("Student must be enrolled in the subject before registering for the exam");
        //     }
        // }
    }
}



