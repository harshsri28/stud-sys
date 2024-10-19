package com.system.student.repository;

import com.system.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// we take Integer type because in student model we  have id primary key type is integer
// so jpa takes the type of primary key
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
