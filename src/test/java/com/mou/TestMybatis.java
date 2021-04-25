package com.mou;

import com.mou.dao.StudentDao;
import com.mou.domain.MyStudent;
import com.mou.domain.Student;
import com.mou.utils.MyBatisUtils;
import com.mou.vo.QueryParam;
import com.mou.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {


    @Test
    public void selectStudentByIdTest() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1001);
        System.out.println("学生="+student);

    }

    //多个参数,直接传参
    @Test
    public void selectStudentMuliParamTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudentMuliParam("刘备",20);
        for (Student stu:students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();

    }
    @Test
    public void selectStudentReturnViewStudentTest() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        ViewStudent viewStudent=dao.selectStudentReturnViewStudent(1001);
        System.out.println("学生="+viewStudent);

    }

    @Test
    public void countStudentTest() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int  count= dao.countStudent();
        System.out.println("学生数量="+count);

    }

    @Test
    public void selectByMapTest() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<Object,Object> map= dao.selectByMap(1001);
        System.out.println(map);

    }

    @Test
    public void selectAllStudentsTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAllStudents();
        for (Student stu:students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();

    }


    //展示resultMap  方法1  当数据库列名和返回对象的属性名不一致时的result方法
    @Test
    public void selectAllStudentsTest2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudents = dao.selectAllStudents2();
        for (MyStudent stu:myStudents){
            System.out.println("学生="+stu);
        }
        sqlSession.close();

    }

    //展示resultMap  方法2  当数据库列名和返回对象的属性名不一致时的result方法
    @Test
    public void selectDiffCoilPropertyTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudents = dao.selectDiffCoilProperty();
        for (MyStudent stu:myStudents){
            System.out.println("学生="+stu);
        }
        sqlSession.close();

    }


    //第一种 like,---> Java代码指定like内容(推荐使用)
    @Test
    public void selectlikeOneTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name="%李%";
        List<Student> students = dao.selectlikeOne(name);
        for (Student stu:students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();

    }

    //第二种方式 在sql语句中拼接like的内容
    @Test
    public void selectlikeTwoTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name="李";
        List<Student> students = dao.selectlikeTwo(name);
        for (Student stu:students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();

    }
}

