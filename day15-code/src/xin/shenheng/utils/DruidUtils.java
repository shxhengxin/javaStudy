package xin.shenheng.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtils {
    //工具类，私有化无参构造
    private DruidUtils(){}

    // 静态数据源变量，供全局操作且用于静态代码块加载资源。
    private static DataSource dataSource;


    static {

       //加载配置文件
        InputStream stream = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties pro = new Properties();
        try {
            pro.load(stream);
            //获取资源 DataSource
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建数据库连接实例
     * @return
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw  new RuntimeException("获取数据库连接异常");
    }

    /**
     * 获取连接池方法
     * @return
     */
    public static  DataSource getDataSource () {
        return  dataSource;
    }


    /**
     * 释放数据库连接 connection 到数据库缓存池，pStatement 资源
     * @param pStatement 数据库操作语句
     * @param connection 数据库连接对象
     */
    public static void close(PreparedStatement pStatement, Connection connection) {
       close(null,pStatement,connection);
    }


    /**
     * 释放数据库连接 connection 到数据库缓存池，并关闭 rSet 和 pStatement 资源
     * @param rSet 数据库处理结果集
     * @param pStatement 数据库操作语句
     * @param connection 数据库连接对象
     */
    public static void close(ResultSet rSet, PreparedStatement pStatement, Connection connection) {
        try {
            if (rSet != null) {
                rSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
