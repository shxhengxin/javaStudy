package xin.shenheng.service.factory;

import xin.shenheng.service.IAccountService;
import xin.shenheng.service.impl.AccountServiceImpl;

public class InstanceFactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
