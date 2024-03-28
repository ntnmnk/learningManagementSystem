package com.learning.learningmanagementsystem.models;

import java.util.*;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_subject",
               joinColumns = @JoinColumn(name = "student_id"),
               inverseJoinColumns = @JoinColumn(name = "subject_id"))

    private List<Subject> subjects=new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_exam",
               joinColumns = @JoinColumn(name = "student_id"),
               inverseJoinColumns = @JoinColumn(name = "exam_id"))

    private List<Exam> exams=new ArrayList<>();
}
