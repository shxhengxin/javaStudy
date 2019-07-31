package xin.shenheng.factory;


import xin.shenheng.service.IAccountService;
import xin.shenheng.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {


    private IAccountService accountService;
    private TransactionManager txManager;

    public  final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public IAccountService getAccountService(){
     return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),accountService.getClass().getInterfaces(),new InvocationHandler() {
                  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                      if("test".equals(method.getName())) {
                          return  method.invoke(accountService,args);
                      }
                      Object rtValut = null;
                      try{
                          txManager.beginTransaction();
                          rtValut = method.invoke(accountService,args);
                          txManager.commit();
                          return rtValut;
                      }catch (Exception e) {
                          txManager.rollback();
                          throw  new RuntimeException(e);
                      }finally {
                          txManager.release();
                      }
                  }
              });
    }
}
