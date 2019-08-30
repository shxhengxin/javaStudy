package xin.shenheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.shenheng.dao.AccountDao;
import xin.shenheng.domain.Account;
import xin.shenheng.service.AccountService;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    public List<Account> findAll() {

        return accountDao.findAll();
    }


    public void saveAccount(Account account) {
        System.out.println("业务层:保存账户信息....");
        accountDao.saveAccount(account);
    }
}
