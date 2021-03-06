package xin.shenheng.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.shenheng.dao.IAccountDao;
import xin.shenheng.domain.Account;
import xin.shenheng.service.IAccountService;
import xin.shenheng.utils.TransactionManager;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;



    public List<Account> findAllAccount() {

        List<Account> accounts = accountDao.findAllAccount();

        return accounts;

    }

    public Account findAccountById(Integer accountId) {

            Account account =  accountDao.findAccountById(accountId);

            return account;

    }

    public void saveAccount(Account account) {

            accountDao.saveAccount(account);


    }

    public void updateAccount(Account account) {


            accountDao.updateAccount(account);

    }

    public void deleteAccount(Integer acccountId) {

            accountDao.deleteAccount(acccountId);

    }

    public void transfer(String sourceName, String targetName, Float money) {

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


           //int i = 1/0;
            //2.6更新转入账户
            accountDao.updateAccount(target);

    }
}
