package com.example.Exercice3.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exercice3.Models.Student;
import com.example.Exercice3.Service.StudentService;

@RestController
@RequestMapping("api/v1")
public class StudentsRestController {
    
    private final StudentService studentService;
    @Autowired
    public StudentsRestController(StudentService studentService){
        this.studentService = studentService;
    }
    
    @GetMapping
    public List<Student> getAllStudentsRest(){
        return studentService.getAllStudents();
    }

    @GetMapping("/id")
    public Student getStudentByIdRest(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudentRest(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudentRest(@PathVariable Long id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentRest(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

}
