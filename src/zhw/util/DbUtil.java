package zhw.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @auther 张鸿伟
 * @date 2021/1/6 10:26:28
 * @description
 */
/**
 * 项目名 BookManager
 * <br>包名 util
 * <br>描述 数据库工具类
 */
public class DbUtil {
    public static final String JDBC_DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //public static final String URL = "jdbc:mysql://127.0.0.1:3306/db_book" +"?useUnicode=true&useSSL=false" + "?allowPublicKeyRetrieval=true&useSSL=false" + "&characterEncoding=utf-8&serverTimezone=UTC";
    public static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=House";
    public static final String USERNAME = "log1";
    public static final String PASSWORD = "123";
    /**
     * 获取数据库连接
     *
     * @return java.sql.Connection
     */
    public Connection getConnection() throws Exception {
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return conn;
    }
    /**
     * 关闭数据库连接
     *
     * @param connection 数据库连接
     * @return void
     */
    public void closeConnection(Connection connection) throws SQLException {
        if(connection!=null){
            connection.close();
        }
    }
}
