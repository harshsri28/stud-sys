package com.system.student.service;

import com.system.student.exception.BadRequest;
import com.system.student.model.Student;
import com.system.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow(() -> new BadRequest("Student with id " + id + " not found"));
    }

    public Student updateStudent(int id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new BadRequest("Cannot update. Student with id " + id + " not found"));

        // Update student details
        existingStudent.setName(updatedStudent.getName());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudentById(int id) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new BadRequest("Cannot delete. Student with id " + id + " not found"));

        studentRepository.delete(existingStudent);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
