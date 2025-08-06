package com.example.physicsquiz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sl;

    @Column(name = "student_id", unique = true, nullable = false)
    private String studentId;

    // Constructors
    public Student() {}

    public Student(String studentId) {
        this.studentId = studentId;
    }

    // Getters and Setters
    public Integer getSl() { return sl; }
    public void setSl(Integer sl) { this.sl = sl; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
}