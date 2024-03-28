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

    @ManyToMany
    // @JoinTable(
    //     name = "student_subject",
    //     joinColumns = @JoinColumn(name = "subject_id"),  
    //     inverseJoinColumns = @JoinColumn(name = "student_id",nullable = true)
    // )
    private List<Subject> subjects=new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    
    // @JoinTable(
    //     name = "student_exam",
    //     joinColumns = @JoinColumn(name = "exam_id"),
    //     inverseJoinColumns = @JoinColumn(name = "student_id",nullable = true)
    // )
    private List<Exam> exams=new ArrayList<>();
}
