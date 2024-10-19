package com.system.student.controller;


import com.system.student.model.Student;
import com.system.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/students/")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/create")
    public Student addStudent(@RequestBody Student student) {
        // Saving the student to the database
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
    public Student getStudentInfo(@PathVariable int id) {
        return studentRepository.findById(id).orElse(null);
    }
}
