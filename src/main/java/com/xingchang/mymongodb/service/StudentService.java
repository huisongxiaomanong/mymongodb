package com.xingchang.mymongodb.service;

import com.xingchang.mymongodb.model.Student;

public interface StudentService {
    void save(Student student);
    Student queryStudentByName(Student student);
    void modifyStudent(Student student);
    void deleteStudent(Student student);
}
