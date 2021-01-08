import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * author: 刘晓霞
 * function: 用户注册数据的处理
 * time: 2021.01.09
 */

public class HandleInsertData {
    Connection con;
    PreparedStatement preparedStatement = null;

    public HandleInsertData() {
        Link link = new Link();
        try {
            con = link.linker();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeRegisterModel (Register register) throws SQLException {
        String sqlStr = "insert into User(密码, 账户类型) values(?,?)";
        int ok = 0;
        try {
            preparedStatement = con.prepareStatement(sqlStr);
            preparedStatement.setString(1, register.getPassword());
            preparedStatement.setString(2, register.getZhangHuLeiXing());
            ok = preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (ok != 0) {
            int id = SelectID.getId();
            JOptionPane.showMessageDialog(null, "注册成功!您的账号为：" + id, "恭喜", JOptionPane.WARNING_MESSAGE);
        }
    }
}
