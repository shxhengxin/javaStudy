package xin.shenheng.demo03;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3PODemo01 {
    public static void main(String[] args) {
        //创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        try {

            for (int i = 1; i <=10 ; i++) {
                Connection conn = ds.getConnection();
                System.out.println(conn);
            }


            //System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
