package com.mou.dao;

import com.mou.domain.MyStudent;
import com.mou.domain.Student;
import com.mou.vo.QueryParam;
import com.mou.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {



    public Student selectStudentById(Integer id);


    public List<Student> selectStudentMuliParam(@Param("myname")String name,@Param("myage")Integer age);

    ViewStudent selectStudentReturnViewStudent(@Param("sid")Integer id);

    int countStudent();

    //返回map
    Map<Object,Object> selectByMap(int id);

    /*
    *使用resultMap定义映射关系
     */
    List<Student> selectAllStudents();

   // 展示resultMap    方法1    当数据库列名和返回对象的属性名不一致时的result方法
    List<MyStudent> selectAllStudents2();

    // 展示resultMap    方法2    当数据库列名和返回对象的属性名不一致时的result方法
    List<MyStudent> selectDiffCoilProperty();

    //第一种 like,---> Java代码指定like内容(推荐使用)
    List<Student>  selectlikeOne(String name);

    //第二种方式 在sql语句中拼接like的内容
    List<Student>  selectlikeTwo(String name);
}
