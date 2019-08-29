package xin.shenheng.service.impl;

import org.springframework.stereotype.Service;
import xin.shenheng.domain.Account;
import xin.shenheng.service.AccountService;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    public List<Account> findAll() {
        System.out.println("业务层:查询所有账户信息....");
        return null;
    }


    public void saveAccount(Account account) {
        System.out.println("业务层:保存账户信息....");
    }
}
