package com.system.student.controller;

import com.system.student.model.Student;
import com.system.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        // Basic validation
        if (student.getName() == null || student.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Name is required");
        }
        Student createdStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentInfo(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        // Basic validation
        if (updatedStudent.getName() == null || updatedStudent.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Name is required");
        }
        Student updatedStudentResult = studentService.updateStudent(id, updatedStudent);
        return ResponseEntity.ok(updatedStudentResult);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content, no body needed
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
}
