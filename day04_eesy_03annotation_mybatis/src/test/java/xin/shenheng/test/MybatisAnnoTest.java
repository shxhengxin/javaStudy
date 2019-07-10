package xin.shenheng.test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xin.shenheng.dao.IUserDao;
import xin.shenheng.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisAnnoTest {

    public static  void  main(String[] args) throws IOException {
        //获取字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //根据字节输入流构建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        //SqlSessionFactory工厂生产一个SqlSession
        SqlSession sqlSession = factory.openSession();

        //SqlSession 获取代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);

        List<User> users = iUserDao.findAll();
        System.out.println(users);

        sqlSession.close();
        in.close();
    }
}
