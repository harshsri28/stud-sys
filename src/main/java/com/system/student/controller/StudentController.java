package com.system.student.controller;


import com.system.student.model.Student;
import com.system.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/students/")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/create")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
    public Student getStudentInfo(@PathVariable int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public Student updateStudentInfo(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> studentInfo = studentRepository.findById(id);

        if(studentInfo.isPresent()){
            Student studentDetails = studentInfo.get();
            studentDetails.setName(student.getName());
            studentDetails.setStudentId(student.getStudentId());
            return studentRepository.save(studentDetails);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentInfo(@PathVariable int id) {
        Optional<Student> studentInfo= studentRepository.findById(id);

        if(studentInfo.isPresent()){
            studentRepository.delete(studentInfo.get());
            return "success";
        }else{
            return "Data not Found";
        }
    }
}
