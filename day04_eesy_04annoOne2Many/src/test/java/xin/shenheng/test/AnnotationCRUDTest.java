package xin.shenheng.test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import xin.shenheng.dao.IUserDao;
import xin.shenheng.domain.Account;
import xin.shenheng.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void  init() throws IOException {
        //获取字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //根据字节输入流构建SqlSessionFactory工厂
        factory = new SqlSessionFactoryBuilder().build(in);

        //SqlSessionFactory工厂生产一个SqlSession
        sqlSession = factory.openSession();

        //SqlSession 获取代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }


    @After
    public void destroy() throws IOException {
        sqlSession.commit();//提交事务
        sqlSession.close();
        in.close();
    }


    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("========每个用户对应多个帐户========");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(48);
        System.out.println(user);
    }

    @Test
    public void  testFindByUserName(){

        List<User> users = userDao.findUserByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }



}
