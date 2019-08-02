package xin.shenheng.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import xin.shenheng.dao.IAccountDao;
import xin.shenheng.dao.impl.AccountDaoImpl;


import javax.sql.DataSource;


public class JdbcTemplateDemo2 {



    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        //3.执行操作
        jt.execute("insert into account(name,money)values('eeeee',2222)");



    }
}
