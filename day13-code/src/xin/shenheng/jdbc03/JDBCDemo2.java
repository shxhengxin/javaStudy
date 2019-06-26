package xin.shenheng.jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo2 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection connection = null;
        try {
            String sql = " insert into account values(null,'王五',3000)";
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "root");

            stmt = connection.createStatement();

            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if(count>0) {
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }





    }
}
