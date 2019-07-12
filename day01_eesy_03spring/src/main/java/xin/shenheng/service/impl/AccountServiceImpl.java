package xin.shenheng.service.impl;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xin.shenheng.dao.IAccountDao;
import xin.shenheng.dao.impl.AccountDaoImpl;
import xin.shenheng.service.IAccountService;

/**
 * 帐户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {


    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void saveAccount() {

        //BeanFactory ac = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext ac =  new ClassPathXmlApplicationContext("bean.xml");
        //IAccountDao accountDao = (IAccountDao) ac.getBean("accountDao");
        //accountDao.saveAccount();

    }


}
