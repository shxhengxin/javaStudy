package xin.shenheng.service.impl;

import org.springframework.stereotype.Service;
import xin.shenheng.service.IAccountService;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新");
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
