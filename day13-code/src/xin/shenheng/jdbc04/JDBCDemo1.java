package xin.shenheng.jdbc04;

import cn.itcast.domain.Accout;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo1 {
    /**
     * 查询所account对象
     * @return
     */
    public List<Accout> findAll()  {
        Connection connection = null;
        Statement stmt = null;
        ResultSet result = null;
        Accout accout = null;
        List<Accout> list = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "root");
            stmt = connection.createStatement();
            String sql = " select * from account ";


            result = stmt.executeQuery(sql);

            list = new ArrayList<Accout>();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int balance = result.getInt("balance");
                accout = new Accout();
                accout.setId(id);
                accout.setName(name);
                accout.setBalance(balance);
                list.add(accout);
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

        return list;
    }



    public static void main(String[] args) {
        List<Accout> list = new JDBCDemo1().findAll();
        System.out.println(list);
        System.out.println(list.size());

    }
}
