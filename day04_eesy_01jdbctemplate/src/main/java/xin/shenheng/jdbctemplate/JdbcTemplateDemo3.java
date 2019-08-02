package xin.shenheng.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import xin.shenheng.dao.IAccountDao;
import xin.shenheng.domain.Account;

import java.util.List;


public class JdbcTemplateDemo3 {



    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        //jt.update("insert into account(name,money) values (?,?)","ffff",3333f);

        List<Account> accounts = jt.query("select * from account where money > ?", new BeanPropertyRowMapper<Account>(Account.class), 1000f);
        for (Account account : accounts) {
            System.out.println(account);
        }

    }
}
