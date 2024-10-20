package com.system.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Auto-generated by the database

    private String studentId; // This will be a unique identifier for the student
    private String name;

    // Default constructor required by JPA
    public Student() {}

    // Constructor without id, as it's auto-generated
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
