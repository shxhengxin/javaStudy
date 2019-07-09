package xin.shenheng.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import xin.shenheng.dao.IUserDao;
import xin.shenheng.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao iUserDao;

    @Before
    public void init() throws IOException {
        //读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //使用工厂生产SqlSession对象
        session = factory.openSession();

        //使用SqlSession创建Dao接口的代理对象
        iUserDao = session.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws IOException {
        session.commit();//提交事务
        session.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<User> users = iUserDao.findAll();
        for (User user : users) {
            System.out.println("========每个用户的信息=======");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }

    }

}
