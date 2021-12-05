package com.akshitbaunthy.springmvc.controller;

import com.akshitbaunthy.springmvc.entity.Student;
import com.akshitbaunthy.springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> studentList = studentService.printAll();
        model.addAttribute("Students", studentList);
        return "list-Students";
    }

    @PostMapping("/insert")
    public String insertStudent(@RequestParam("name") String name, @RequestParam("department") String department, @RequestParam("country") String country) {
        Student student = new Student();
        student.setName(name);
        student.setCountry(country);
        student.setDepartment(department);
        studentService.insert(student);
        return "redirect:/students/list";
    }

    @PostMapping("/update")
    public String updateStudent(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("department") String department, @RequestParam("country") String country) {
        Student student = new Student();
        if(id!=0) {
            student = studentService.findById(id);
            student.setName(name);
            student.setDepartment(department);
            student.setCountry(country);
        }
        else {
            student = new Student(name, department, country);
        }
        studentService.insert(student);
        return "redirect:/students/list";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        studentService.delete(id);
        return "redirect:/students/list";
    }

}
