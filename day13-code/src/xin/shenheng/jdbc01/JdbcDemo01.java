package xin.shenheng.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {

        //注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

        String sql = " update  account set balance = 1000";

        //获取执行sql对象
        Statement stmt = conn.createStatement();

        int count = stmt.executeUpdate(sql);


        //String sql1 = "select * from account";
        //ResultSet resultSet = stmt.executeQuery(sql1);



        System.out.println(count);
        stmt.close();
        conn.close();



    }
}
