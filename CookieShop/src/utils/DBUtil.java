package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static DataSource ds = new ComboPooledDataSource();

    // 数据源
    public static DataSource getDataSource(){
        DataSource ds = new ComboPooledDataSource();
        return ds;
    }

    // 拿到连接对象
    public static Connection getConnetction() throws SQLException {
        return ds.getConnection();
    }
}
