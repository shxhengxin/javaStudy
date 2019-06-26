package xin.shenheng.druid;


import cn.itcast.domain.Accout;
import xin.shenheng.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DruidDemo {
    public static void main(String[] args) {

        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        Connection conn = DruidUtils.getConnection();

        String sql = " select * from account";
        try {
            pstmt = conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            List<Accout> list = new ArrayList<>();
            while (resultSet.next()) {
                Accout accout = new Accout();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int balance = resultSet.getInt("balance");
                accout.setId(id);
                accout.setName(name);
                accout.setBalance(balance);
                list.add(accout);

            }

            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close(resultSet,pstmt,conn);
        }


    }
}
