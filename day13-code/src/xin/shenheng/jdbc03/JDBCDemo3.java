package xin.shenheng.jdbc03;

import java.sql.*;

public class JDBCDemo3 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection connection = null;
        ResultSet result = null;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "root");

            stmt = connection.createStatement();


            String sql = " select * from account ";


            result = stmt.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt(1);
                String name = result.getString("name");
                double ba = result.getDouble(3);
                System.out.println(id);
                System.out.println(name);
                System.out.println(ba);

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
