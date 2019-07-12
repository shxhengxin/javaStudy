package xin.shenheng.service.factory;

import xin.shenheng.service.IAccountService;
import xin.shenheng.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
