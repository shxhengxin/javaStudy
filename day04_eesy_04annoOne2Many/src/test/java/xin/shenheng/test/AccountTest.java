package xin.shenheng.test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import xin.shenheng.dao.IAccountDao;
import xin.shenheng.dao.IUserDao;
import xin.shenheng.domain.Account;
import xin.shenheng.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before
    public void  init() throws IOException {
        //获取字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //根据字节输入流构建SqlSessionFactory工厂
        factory = new SqlSessionFactoryBuilder().build(in);

        //SqlSessionFactory工厂生产一个SqlSession
        sqlSession = factory.openSession();

        //SqlSession 获取代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);

    }


    @After
    public void destroy() throws IOException {
        sqlSession.commit();//提交事务
        sqlSession.close();
        in.close();
    }


    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("---每个帐户的信息-----");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void testFindOne(){

    }

    @Test
    public void  testFindByUserName(){


    }



}
