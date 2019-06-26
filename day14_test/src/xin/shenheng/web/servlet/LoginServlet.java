package xin.shenheng.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import xin.shenheng.dao.UserDao;
import xin.shenheng.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        /*String username = request.getParameter("username");
        String password = request.getParameter("password");

        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/

        //获取所有请求参数
        Map<String, String[]> map = request.getParameterMap();
        //创建对象
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,map);


            UserDao dao = new UserDao();
            User user = dao.login(loginUser);
            if(user == null ) {
                request.getRequestDispatcher("/failServlet").forward(request,response);
            }else {
                request.setAttribute("user",user);
                request.getRequestDispatcher("/successServlet").forward(request,response);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
