package com.gcu.controller;

import com.gcu.biz.StudentBiz;
import com.gcu.entity.Json;
import com.gcu.entity.Student;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import java.util.List;
import javax.servlet.http.HttpSession;

@Controller
public class StudentController {

    @Autowired
    private StudentBiz studentBizImpl;

    @RequestMapping("/index")
    public String toLogin(){
        return "student.html";
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public Object selectAll(int page,int limit){
        PageHelper.startPage(page,limit);
        //开始查询
        List<Student> studentList = studentBizImpl.selectAll();
        PageInfo<Student> pageInfo=new PageInfo<>(studentList);
        Json json = new Json();
        json.setCode(0);
        json.setMsg("返回消息");
        json.setCount(pageInfo.getTotal());
        json.setData(pageInfo.getList());
        return json;
        /*List<MyUserInfo> userInfoList = userBizImpl.selectAllUser();
        //结束分页,pageInfo封装了分页之后所有数据
        PageInfo<MyUserInfo> pageInfo = new PageInfo(userInfoList);
        LayUITable layUITable = new LayUITable();
        layUITable.setCode(0);
        layUITable.setMsg("返回消息");
        //设置分页之后的返回值
        layUITable.setCount(pageInfo.getTotal());
        layUITable.setData(pageInfo.getList());
        return layUITable;*/

        /*ist<Student> students = studentBizImpl.selectAll();
        Json json = new Json();
        json.setCode(0);
        json.setCount(100);
        json.setMsg("返回消息");
        json.setData(students);
        return json;*/
    }

    @RequestMapping(value = "/deleteStudent",method = RequestMethod.GET)
    @ResponseBody
    public int deleteStudent(String id){
        int i=studentBizImpl.deleteByPrimaryKey(id);
        return i;
    }

    @RequestMapping(value = "/updateStudent",method = RequestMethod.POST)
    @ResponseBody
    public int updateStudent(Student student){
        int returnCode=0;
        if(studentBizImpl.updateByPrimaryKey(student)==1){
            returnCode=200;
            return returnCode;
        }else{
            return returnCode;
        }
    }

    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    @ResponseBody
    public int addStudent(Student student){
        int returnCode=0;
        if(studentBizImpl.insert(student)==1){
            returnCode=200;
            return returnCode;
        }else{
            return returnCode;
        }
    }
}
