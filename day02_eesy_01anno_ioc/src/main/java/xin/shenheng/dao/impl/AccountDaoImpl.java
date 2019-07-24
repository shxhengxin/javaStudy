package xin.shenheng.dao.impl;

import org.springframework.stereotype.Repository;
import xin.shenheng.dao.IAccountDao;

/**
 * 帐户持久层实现类
 */
@Repository
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存了帐户");
    }
}
