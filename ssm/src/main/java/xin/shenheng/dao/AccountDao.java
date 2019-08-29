package xin.shenheng.dao;

import xin.shenheng.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    public void  saveAccount(Account account);
}
