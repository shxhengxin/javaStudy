package xin.shenheng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy_spring", "root", "root");
        //获取操作数据库预处理对象

        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //执行sql

        ResultSet rs = pstm.executeQuery();
        //遍历结果
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        //释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
