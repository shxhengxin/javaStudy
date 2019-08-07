package xin.shenheng.service;

import xin.shenheng.domain.Account;

/**
 * 帐户的业务层接口
 */
public interface IAccountService {
    /**
     * 根据id查询账户信息
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);






    void transfer(String sourceName, String targetName, Float money);
















}
