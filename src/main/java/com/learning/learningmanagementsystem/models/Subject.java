package com.learning.learningmanagementsystem.models;

import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Subjects")

@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable=false)
    private String subjectId;

    private String name;

    @OneToMany(mappedBy = "subjects")
    private List<Student> registeredStudents=new ArrayList<>();

    @ManyToMany
    private List<Exam> exams= new ArrayList<>();

}
