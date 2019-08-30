package xin.shenheng.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xin.shenheng.domain.Account;
import xin.shenheng.service.AccountService;

import java.util.List;

public class TestSpring {
    @Test
    public void  run1(){
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        as.findAll();

    }

}
