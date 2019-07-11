package xin.shenheng.ui;

import xin.shenheng.dao.IAccountDao;
import xin.shenheng.factory.BeanFactory;
import xin.shenheng.service.IAccountService;


/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");


            //System.out.println(as);

            as.saveAccount();
        }


    }
}
