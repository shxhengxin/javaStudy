package xin.shenheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.shenheng.domain.Account;
import xin.shenheng.domain.User;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/testParam")
    public String testParam(String username) {

        System.out.println(username);
        return "success";
    }

    @RequestMapping(path = "/saveAccount")
    public String saveAccount(Account account){
        System.out.println("执行了....");
        System.out.println(account);
        return  "success";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println(user);
        return  "success";
    }
}
