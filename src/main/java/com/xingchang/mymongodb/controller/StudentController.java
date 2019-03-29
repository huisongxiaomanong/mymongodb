package com.xingchang.mymongodb.controller;

import com.xingchang.mymongodb.model.Student;
import com.xingchang.mymongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("save")
    public void save(Student student){
        studentService.save(student);
    }
    @GetMapping("load")
    public Student loadByName(Student student) {
        Student student1 = studentService.queryStudentByName(student);
        return student1;
    }

    @GetMapping("modify")
    public void modifyStudent(Student student) {
        studentService.modifyStudent(student);
    }
    @GetMapping("delete")
    public void deleteStudent(Student student) {
        studentService.deleteStudent(student);
    }
}
