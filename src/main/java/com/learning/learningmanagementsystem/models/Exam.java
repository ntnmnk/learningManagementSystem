package com.learning.learningmanagementsystem.models;

import java.util.*;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name = "Exams")
@Data
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToMany(mappedBy = "exams")
    private List<Student> students=new ArrayList<>();
}
