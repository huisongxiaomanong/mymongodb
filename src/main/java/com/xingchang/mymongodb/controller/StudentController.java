package com.xingchang.mymongodb.controller;

import com.xingchang.mymongodb.model.Student;
import com.xingchang.mymongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController() {
    }
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 保存一个对象
     * @param student:参数
     */
    @PostMapping("save")
    public void save(Student student){
        studentService.save(student);
    }

    /**
     * 通过名字查询
     * @param student:参数
     * @return studentResult
     */
    @GetMapping("load")
    public Student loadByName(Student student) {
        return studentService.queryStudentByName(student);
    }

    /**
     * 更新一个学生（先通过ID查询然后再修改年龄）
     * @param student:参数
     */
    @PutMapping("modify")
    public void modifyStudent(Student student) {
        studentService.modifyStudent(student);
    }

    /**
     * 删除一个学生（通过ID查询然后删除）
     * @param student:参数
     */
    @DeleteMapping("delete")
    public void deleteStudent(Student student) {
        studentService.deleteStudent(student);
    }
}
