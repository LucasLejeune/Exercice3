package com.example.Exercice3.Service;

import java.util.List;

import com.example.Exercice3.Models.Student;

public interface StudentService {
    
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student createStudent(Student student);

    Student updateStudent(Long id,Student updateStudent);

    void deleteStudent(Long id);
}
