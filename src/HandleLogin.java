import javax.swing.*;
import java.sql.*;

/**
 * author: 刘晓霞
 * function: 管理用户登录
 * time: 2021.01.09
 */

public class HandleLogin {
    Connection con;
    PreparedStatement preSql;
    ResultSet rs;
    public HandleLogin() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e1) {
            System.out.println(e1.getMessage());
        }
        String sql_url = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=ErShouFang";
        try {
            con = DriverManager.getConnection(sql_url, "log1","123");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Login queryVerify(Login loginModel) {
        String id = loginModel.getId();
        String pw = loginModel.getPassword();
        String sqlStr = "select id,password from register where " + "id = ? and password = ?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, id);
            preSql.setString(2, pw);
            rs = preSql.executeQuery();
            if (rs.next() == true) {
                loginModel.setLoginSuccess(true);
                JOptionPane.showMessageDialog(null, "登录成功", "恭喜", JOptionPane.WARNING_MESSAGE);
            }
            else {
                loginModel.setLoginSuccess(false);
                JOptionPane.showMessageDialog(null, "登录失败", "登陆失败，重新登录", JOptionPane.WARNING_MESSAGE);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return loginModel;
    }
}
