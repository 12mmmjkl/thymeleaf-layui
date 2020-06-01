package com.gcu.biz;

import com.gcu.entity.Student;

import java.util.List;

public interface StudentBiz {
    List<Student> selectAll();
    int deleteByPrimaryKey(String id);
    int updateByPrimaryKey(Student record);
    int insert(Student record);
}
