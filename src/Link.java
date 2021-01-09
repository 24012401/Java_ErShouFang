import javax.naming.spi.DirStateFactory;
import java.sql.*;

/**
 * author: 刘晓霞
 * function: 连接数据库库，返回 Connection 类的对象
 * time: 2021.01.09
 */

public class Link {
    public static String sql_url = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=House";
    public static String name_ = "log1";
    public static String password_ = "123";
    public static Connection connection;

    public static Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(sql_url, name_, password_);
        return connection;
    }

    public static void result(Connection connection, Statement statement) throws SQLException {
        connection.close();
        statement.close();
    }
    public static void result(Connection connection, PreparedStatement preparedStatement) throws SQLException {
        connection.close();
        preparedStatement.close();
    }
}
