package xin.shenheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.shenheng.domain.Account;
import xin.shenheng.service.AccountService;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(){

        System.out.println("findAll执行了....");
        List<Account> list = accountService.findAll();
        //System.out.println(list);

        return "list";
    }
}
