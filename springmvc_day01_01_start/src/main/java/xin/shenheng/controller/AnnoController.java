package xin.shenheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 常用的注解
 */

@Controller
@RequestMapping("/anno")
public class AnnoController {

    @RequestMapping("/testRequestParam")

    public String testRequestParam(@RequestParam(name = "username",required = false) String userName){
        System.out.println("执行了.....");
        System.out.println(userName);
        return "success";
    }


    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(name="id") String id){
        System.out.println("执行了.....");
        System.out.println(id);
        return "success";
    }


}
