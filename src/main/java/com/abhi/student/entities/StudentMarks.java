package com.abhi.student.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "marks")
@Data
public class StudentMarks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "marks_id")
    private int id;
    private int java_marks;
    private int english_marks;
    private int math_marks;
    private int oracle_marks;

    @OneToOne
    @JsonBackReference
    private Student student;
}
