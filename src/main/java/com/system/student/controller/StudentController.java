package com.system.student.controller;


import com.system.student.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/students/")
public class StudentController {
    private Map<Integer, Student> studentsCollection = new HashMap<>();
    private int numberOfStudent  =1 ;

    @PostMapping("/create")
    public Student addStudent(@RequestBody Student student) {
        student.setId(numberOfStudent);
        studentsCollection.put(student.getId(), student);
        numberOfStudent++;
        return student;
    }

    @GetMapping("/{id}")
    public Student getStudentInfo(@PathVariable int id){
        return studentsCollection.containsKey(id) ? studentsCollection.get(id) : null;
    }
}
