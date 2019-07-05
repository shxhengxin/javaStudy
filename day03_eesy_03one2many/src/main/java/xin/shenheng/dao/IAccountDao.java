package xin.shenheng.dao;

import xin.shenheng.domain.Account;
import xin.shenheng.domain.AccountUser;

import java.util.List;

public interface IAccountDao {

    List<Account> findAll();

    List<AccountUser> findAllAccount();
}
