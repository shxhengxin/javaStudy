package xin.shenheng.demo01;

import cn.itcast.domain.Accout;
import xin.shenheng.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDmeo01 {
    /**
     * 查询所account对象
     * @return
     */
    public List<Accout> findAll(int id1)  {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        Accout accout = null;
        List<Accout> list = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = " select * from account where id=? ";
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1,id1);
            result = stmt.executeQuery();

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
            JDBCUtils.close(result,stmt,connection);
        }

        return list;
    }



    public static void main(String[] args) {
        List<Accout> list = new JDBCDmeo01().findAll(1);
        System.out.println(list);
        System.out.println(list.size());

    }
}
