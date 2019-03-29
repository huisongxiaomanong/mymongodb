package com.xingchang.mymongodb.dao;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.xingchang.mymongodb.model.Student;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StudentDao {
    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     */
    public void save(Student student) {
        Student save = mongoTemplate.save(student);
    }

    /*
    * 根据用户名查询
    * */
    public Student findByName(Student student) {
        Query query = new Query(Criteria.where("name").is(student.getName()));
        Student one = mongoTemplate.findOne(query, Student.class);
        return one;
    }

    /**
     * 更新或者修改对象
     * */
    public void update(Student student) {
        //更新是一样的道理先进行查询然后进行修改
        Query query = new Query(Criteria.where("id").is(student.getId()));
        Update update = new Update().set("age",student.getAge());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, student.getClass());
        System.out.println("修改操作成功并且返回的结果是：*********》》》》》》》》》"+updateResult.toString());
    }

    /**
     * 删除一个对象或者是一个文档
     * */
    public void delete(Student student) {
        Query query = new Query(Criteria.where("id").is(student.getId()));
        DeleteResult remove = mongoTemplate.remove(query, Student.class);
        System.out.println("删除操作成功并且返回的结果是：》》"+ remove.toString());
    }
}
