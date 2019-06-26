package xin.shenheng.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;


    static {

        try {
            Properties pro = new Properties();
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();

            InputStream stream = classLoader.getResourceAsStream("jdbc.properties");
            pro.load(stream);

           /* URL res = classLoader.getResource("jdbc.properties");

            String path = res.getPath();
            pro.load(new FileReader(path));*/

            url = pro.getProperty("url");

            user = pro.getProperty("user");

            password = pro.getProperty("password");

            driver = pro.getProperty("driver");

            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }


    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn){
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 释放资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null) {
            try {
                rs.close();
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

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
