package xin.shenheng.demo02;

import xin.shenheng.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            conn = JDBCUtils.getConnection();


            //开启事务
            conn.setAutoCommit(false);

            String sql1 = "update account set balance= balance - ?  where id=?";
            String sql2 = "update account set balance= balance + ?  where id=?";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            pstmt1.setInt(1,500);
            pstmt1.setInt(2,1);
            pstmt2.setInt(1,500);
            pstmt2.setInt(2,2);

            pstmt1.executeUpdate();

            pstmt2.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                if(conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt1,conn);
            JDBCUtils.close(pstmt2,null);
        }

    }
}
