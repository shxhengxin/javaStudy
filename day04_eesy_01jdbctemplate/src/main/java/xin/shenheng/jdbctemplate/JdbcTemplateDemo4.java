package xin.shenheng.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import xin.shenheng.dao.IAccountDao;
import xin.shenheng.domain.Account;


public class JdbcTemplateDemo4 {



    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountDao accountDao = ac.getBean("accountDao",IAccountDao.class);

        Account account = accountDao.findAccountById(1);
        System.out.println(account);

        //account.setMoney(100000f);
        //accountDao.updateAccount(account);


    }
}
