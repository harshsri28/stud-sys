package com.system.student.controller;

import com.system.student.model.Student;
import com.system.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        if (student.getName() == null || student.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Name is required");
        }
        Student createdStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentInfo(@PathVariable int id) {
        Optional<Student> studentOptional = studentService.getStudentById(id);

        if (studentOptional.isPresent()) {
            return ResponseEntity.ok(studentOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        if (updatedStudent.getName() == null || updatedStudent.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Name is required");
        }

        Optional<Student> updatedStudentOptional = studentService.updateStudent(id, updatedStudent);

        if (updatedStudentOptional.isPresent()) {
            return ResponseEntity.ok(updatedStudentOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        boolean isDeleted = studentService.deleteStudentById(id);

        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllStudent(){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
}
