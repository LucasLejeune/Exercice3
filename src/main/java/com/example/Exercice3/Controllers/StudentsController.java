package com.example.Exercice3.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Exercice3.Models.Student;
import com.example.Exercice3.Service.StudentService;

@Controller
public class StudentsController {

    private final StudentService studentService;
    @Autowired
    public StudentsController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public String home(){
        return "home";
    }
    
    @GetMapping("/StudentList")
    public String getAllStudents(Model model){
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("studentList", studentList);
        return "studentList";
    }

    @GetMapping("/addStudent")
    public String createStudentView(Model model){
         Student student = new Student();
        model.addAttribute("studentSubmit", student);
        return "newStudent";
    }

    @PostMapping("/submitStudent")
    public String createStudent(@ModelAttribute("studentSubmit")Student student){
        studentService.createStudent(student);
        return "redirect:/StudentList";
    }

    @GetMapping("/{id}")
    public String getStudentById(Model model, @PathVariable Long id){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student );
        if (student != null) {
            return "studentById";   
        }
            return "redirect:/addStudent";
    }

    @GetMapping("/updateStudent")
    public String updateStudentView(Model model, @RequestParam Long id){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student );
        if (student != null) {
            return "update";   
        }
            return "redirect:/addStudent";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("studentSubmit")Student student){
        System.out.println(student);
        studentService.updateStudent(student.getId(), student);        
        return "redirect:/";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam Long id){
        Student student = studentService.getStudentById(id);
        if (student != null) {
           studentService.deleteStudent(id);
        }
        return "redirect:/StudentList";
    }
}
