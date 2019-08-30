package xin.shenheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.shenheng.domain.Account;
import xin.shenheng.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){

        List<Account> list = accountService.findAll();
        System.out.println(list);
        model.addAttribute("list",list);


        return "list";
    }


    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response ) throws IOException {
        System.out.println("11111");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return ;
    }

}
