package xin.shenheng.service.Impl;


import xin.shenheng.dao.IAccountDao;
import xin.shenheng.domain.Account;
import xin.shenheng.service.IAccountService;
import xin.shenheng.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    //private TransactionManager txManager;

    /*public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }*/

    public void  setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }



    public List<Account> findAllAccount() {
        //try{
           // txManager.beginTransaction();
            List<Account> accounts = accountDao.findAllAccount();
           // txManager.commit();
            return accounts;

        //}catch (Exception e){
           // txManager.rollback();
           // throw new RuntimeException(e);
       // }finally {
        //    txManager.release();
      //  }

    }

    public Account findAccountById(Integer accountId) {
        //try{
           // txManager.beginTransaction();
            Account account =  accountDao.findAccountById(accountId);
           // txManager.commit();
            return account;
        //}catch (Exception e){
           // txManager.rollback();
           // throw new RuntimeException(e);
        //}finally {
          //  txManager.release();
        //}
    }

    public void saveAccount(Account account) {
        //try{
           // txManager.beginTransaction();
            accountDao.saveAccount(account);
          //  txManager.commit();

      //  }catch (Exception e){
          //  txManager.rollback();
         //   throw new RuntimeException(e);
      //  }finally {
         //   txManager.release();
       // }

    }

    public void updateAccount(Account account) {

        //try{
          //  txManager.beginTransaction();
            accountDao.updateAccount(account);
         //   txManager.commit();

        //}catch (Exception e){
         //   txManager.rollback();
        //    throw new RuntimeException(e);
       // }finally {
        //    txManager.release();
       // }
    }

    public void deleteAccount(Integer acccountId) {

        //try{
           // txManager.beginTransaction();
            accountDao.deleteAccount(acccountId);
            //txManager.commit();

        /*}catch (Exception e){
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }*/
    }

    public void transfer(String sourceName, String targetName, Float money) {
        //try {
            //txManager.beginTransaction();
            //2.1根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4转入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5更新转出账户
            accountDao.updateAccount(source);

            //int i=1/0;

            //2.6更新转入账户
            accountDao.updateAccount(target);
         /*   txManager.commit();
        }catch (Exception e){
            txManager.rollback();
            e.printStackTrace();
        }finally {
            txManager.release();
        }*/
    }
}
