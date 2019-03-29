package com.xingchang.mymongodb.service.impl;

import com.xingchang.mymongodb.dao.StudentDao;
import com.xingchang.mymongodb.model.Student;
import com.xingchang.mymongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public Student queryStudentByName(Student student) {
        return studentDao.findByName(student);
    }

    @Override
    public void modifyStudent(Student student) {
        studentDao.update(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }
}
