package xin.shenheng.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import xin.shenheng.dao.IUserDao;
import xin.shenheng.domain.QueryVo;
import xin.shenheng.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws IOException{
        //读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //使用工厂生产SqlSession对象
        session = factory.openSession();

        //使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws IOException {
        session.commit();//提交事务
        session.close();
        in.close();
    }


    @Test
    public void  testFindAll()  {
        //使用代理对象执行方法
        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user);
        }

    }


    @Test
    public void testFindOne(){
        User user = userDao.findById(48);
        System.out.println(user);

    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%王%");
        System.out.println(users);

    }



    @Test
    public void  testFindByCondition()  {
        //使用代理对象执行方法

        User u = new User();
        u.setUsername("老王");
        List<User> users = userDao.findUserByCondition(u);

        for (User user : users) {
            System.out.println(user);
        }

    }


    @Test
    public void  testFindByInIds()  {
        //使用代理对象执行方法

        QueryVo vo = new QueryVo();

        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(43);
        vo.setIds(list);
        List<User> users = userDao.findUserInIds(vo);

        for (User user : users) {
            System.out.println(user);
        }

    }




}
