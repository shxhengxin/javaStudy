package xin.shenheng.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import xin.shenheng.dao.AccountDao;
import xin.shenheng.domain.Account;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    @Test
    public void run1() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        //创建SqlSession对象

        SqlSession sqlSession = factory.openSession();

        //获取代理对象

        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        Account account = new Account();
        account.setName("李四");
        account.setMoney(400d);
        dao.saveAccount(account);
       /* List<Account> list = dao.findAll();

        for (Account account:list){
            System.out.println(account);
        }*/
        sqlSession.commit();

        sqlSession.close();
        in.close();
    }
}
