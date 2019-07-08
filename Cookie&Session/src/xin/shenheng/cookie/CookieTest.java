package xin.shenheng.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");




        //request.getRequestDispatcher("/login.jsp").forward(request,response);
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if(cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("lastTime".equals(name)) {
                    flag = true;
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println(str_date);

                    String value = cookie.getValue();
                    value = URLDecoder.decode(value,"utf-8");


                    str_date = URLEncoder.encode(str_date,"utf-8");
                    cookie.setValue(str_date);

                    cookie.setMaxAge(60 * 60 * 24 * 30);

                    response.addCookie(cookie);


                    response.getWriter().write("<h1>欢迎回来,您上次访问时间为:" + value + "</hr>");
                    break;
                }
            }
        }

        if(cookies == null || cookies.length == 0 || flag == false) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println(str_date);
            str_date = URLEncoder.encode(str_date,"utf-8");
            Cookie cookie = new Cookie("lastTime",str_date);

            cookie.setMaxAge(60 * 60 * 24 * 30);

            response.addCookie(cookie);


            response.getWriter().write("<h1>您好,欢迎您首次访问</hr>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
