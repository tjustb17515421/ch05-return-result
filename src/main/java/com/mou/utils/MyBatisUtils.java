package com.mou.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

    private static SqlSessionFactory factory=null;
    static{
        String config="mybatis-config.xml";
        try{
            InputStream in= Resources.getResourceAsStream(config);
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            factory=builder.build(in);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //获取SqlSession方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if (factory!=null){
            sqlSession=factory.openSession();//非自动提交事务
        }
        return sqlSession;
    }
}
