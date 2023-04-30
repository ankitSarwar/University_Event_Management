package com.example.University.Event.Management.controller;

import com.example.University.Event.Management.model.Department;
import com.example.University.Event.Management.model.Student;
import com.example.University.Event.Management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
@Validated
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/Add")
    public String insertStudents(@Valid @RequestBody List<Student> students){
        return studentService.AddStudent(students);
    }

    @GetMapping(value = "/type/{StudentId}")
    public List<Student> getStocksBasedOnType(@PathVariable Integer StudentId)
    {
        return studentService.getStudentByType(StudentId);
    }

    @GetMapping(value = "/all")
    public List<Student> getAll(){
      return studentService.getAll();
    }


    @PutMapping(value = "/update/{department}/{id}")
    public void UpdateDepartment(@PathVariable Department department, @PathVariable Integer id){
        studentService.UpdateDepartment(department,id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }

}


//[
//        {
//        "studentId": 1,
//        "firstName": "Ankit",
//        "lastName": "sarwar",
//        "age": 24,
//        "department": "ME"
//        },
//        {
//        "studentId": 2,
//        "firstName": "Suraj",
//        "lastName": "swar",
//        "age": 22,
//        "department": "CSE"
//        },
//        {
//        "studentId": 3,
//        "firstName": "Onkar",
//        "lastName": "sarwar",
//        "age": 25,
//        "department": "CIVIL"
//        },
//        {
//        "studentId": 4,
//        "firstName": "Abhi",
//        "lastName": "swar",
//        "age": 21,
//        "department": "ECE"
//        }
//]