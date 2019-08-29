package xin.shenheng.service;

import xin.shenheng.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    public void  saveAccount(Account account);
}
