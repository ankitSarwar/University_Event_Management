package com.example.University.Event.Management.service;

import com.example.University.Event.Management.model.Department;
import com.example.University.Event.Management.model.Student;
import com.example.University.Event.Management.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    IStudentRepository studentDao;

    public String AddStudent(List<Student> students) {
        Iterable<Student> list = studentDao.saveAll(students);
        if(list!=null){
            return "Students added to list";
        }else{
            return "Students Could not added!!!!! ";
        }
    }

    public List<Student> getAll() {
        return studentDao.AllGet();
    }

    public List<Student> getStudentByType(Integer studentId) {
        return studentDao.findByStudentId(studentId);
    }

    @Transactional
    public void UpdateDepartment(Department department, Integer id) {
//        int value=Department.ordinal();
        String enumValue=department.name();  // convert to string because sql don't know of Department Enum
        studentDao.modify(enumValue,id);
    }

    @Transactional
    public void deleteStudent(Integer id) {
        studentDao.deleteFromStudent(id);
    }



}
