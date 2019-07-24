package xin.shenheng.service.impl;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import xin.shenheng.dao.IAccountDao;
import xin.shenheng.dao.impl.AccountDaoImpl;
import xin.shenheng.service.IAccountService;

/**
 * 帐户的业务层实现类
 */
@Component
public class AccountServiceImpl implements IAccountService {
    /**
     * <bean id="accountService" class="xin.shenheng.service.impl.AccountServiceImpl"></bean>
     */


    public void saveAccount() {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao as = (IAccountDao) ac.getBean("accountDaoImpl");
        as.saveAccount();
        //BeanFactory ac = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext ac =  new ClassPathXmlApplicationContext("bean.xml");
        //IAccountDao accountDao = (IAccountDao) ac.getBean("accountDao");
        //accountDao.saveAccount();

    }


}
