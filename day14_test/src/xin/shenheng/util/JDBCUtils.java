package xin.shenheng.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;

    static {
        //加载配置文件

        try {
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");

            pro.load(is);

            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接池对象
     */

    public static  DataSource getDataSource() {
        return  ds;
    }


    /**
     * 获取连接Connection对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();

    }
}
