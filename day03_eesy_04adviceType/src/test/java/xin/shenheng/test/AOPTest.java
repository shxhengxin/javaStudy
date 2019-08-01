package xin.shenheng.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xin.shenheng.service.IAccountService;

public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService as = (IAccountService) ac.getBean("accountService");

        as.saveAccount();
    }
}
