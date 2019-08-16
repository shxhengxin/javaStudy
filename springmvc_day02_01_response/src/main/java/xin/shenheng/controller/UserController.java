package xin.shenheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xin.shenheng.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model) {

        System.out.println("testString执行了.....");

        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(20);
        model.addAttribute("user",user);
        return  "success";
    }

    @RequestMapping("/testVoid")
    public void  testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid方法执行了");
        //请求转发，不要写项目名称
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        System.out.println(request.getContextPath() + "/WEB-INF/pages/success.jsp");
        //重定向
        response.sendRedirect(request.getContextPath() + "/index.jsp");

        return;
    }


    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {

        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView执行了.....");

        User user = new User();
        user.setUsername("小三");
        user.setPassword("456");
        user.setAge(20);
        //把user对象存储到mv对象中，也会把User对象存入到request对象
        mv.addObject("user",user);
        //跳转到哪个页面
        mv.setViewName("success");
        return  mv;
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了...");
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        // 做响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        // 做响应
        return user;
    }


}
