import java.sql.*;

/**
 * author: 刘晓霞
 * function: 连接数据库库，返回 Connection 类的对象
 * time: 2021.01.09
 */

public class Link {
    String sql_url = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=House";
    String name_ = "log1";
    String password_ = "123";
    Connection con;

    public Connection linker() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(sql_url, name_, password_);
        return con;
    }
}
