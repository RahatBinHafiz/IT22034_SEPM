package com.example.physicsquiz.repository;

import com.example.physicsquiz.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    boolean existsByStudentId(String studentId);
}