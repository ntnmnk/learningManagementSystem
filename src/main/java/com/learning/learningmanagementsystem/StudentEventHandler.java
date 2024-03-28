package com.learning.learningmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.learning.learningmanagementsystem.models.Exam;
import com.learning.learningmanagementsystem.models.Student;

@RepositoryEventHandler(Student.class)
public class StudentEventHandler {
       @Autowired
    private ExamRegistrationValidator validator;

    @HandleBeforeSave
    public void validateExamRegistration(Student student) {
        for (Exam exam : student.getExams()) {
            if (!validator.validateRegistration(student.getId(), exam.getId())) {
                throw new RuntimeException("Student is not enrolled in the subject for this exam (ID: " + exam.getId() + ")");
            }
        }
    }
}
