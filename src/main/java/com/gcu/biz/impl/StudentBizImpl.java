package com.gcu.biz.impl;

import com.gcu.biz.StudentBiz;
import com.gcu.dao.StudentMapper;
import com.gcu.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentBizImpl implements StudentBiz {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

}
