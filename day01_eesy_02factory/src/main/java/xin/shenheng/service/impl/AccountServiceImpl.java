package xin.shenheng.service.impl;

import org.junit.Before;
import xin.shenheng.dao.IAccountDao;
import xin.shenheng.factory.BeanFactory;
import xin.shenheng.service.IAccountService;

/**
 * 帐户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {





    public void saveAccount() {
        int i = 1;

        IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
        accountDao.saveAccount();
        System.out.println(i);
        ++i;
    }


}
