package fhy;

import javax.swing.*;
import java.sql.*;

public class ControlJDBC {
    public ResultSet exeSql(String sentence) {
        String sql_url = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=House";
        String name_ = "log1";
        String password_ = "123";
        Connection con;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(sql_url, name_, password_);
            preparedStatement = con.prepareStatement(sentence);
            ResultSet result1 = preparedStatement.executeQuery();
            result1.next();
            if (result1.wasNull())
                JOptionPane.showMessageDialog(null, "结果集中无记录");
            return result1;
        } catch (ClassNotFoundException e) {
            System.out.println("未成功加载驱动。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("未成功打开数据库。");
            e.printStackTrace();
        }
        return null;
    }
}