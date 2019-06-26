package xin.shenheng.test;

import org.junit.Test;
import xin.shenheng.dao.UserDao;
import xin.shenheng.domain.User;

public class UserDaoTest {
    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("lisi");
        loginuser.setPassword("123");
        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);
    }
}
