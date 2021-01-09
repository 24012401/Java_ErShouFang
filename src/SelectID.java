import java.sql.*;
import javax.swing.*;

/**
 * author: 刘晓霞
 * function: 查询刚刚注册的用户的ID (弃用)
 * time: 2021.01.09
 */

public class SelectID {
    public static int getId() throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet result1 = null;

        try {
            Connection con = Link.getConnection();
            preparedStatement = con.prepareStatement("select IDENT_CURRENT('Users')");
            result1 = preparedStatement.executeQuery();
            if (result1.wasNull())
                JOptionPane.showMessageDialog(null, "结果集中无记录");
        } catch (ClassNotFoundException e) {
            System.out.println("未成功加载驱动。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("未成功打开数据库。");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultSetMetaData resultSetMetaData = result1.getMetaData();
        String str_id = result1.getString(1).trim();
        return Integer.parseInt(str_id);
    }
}
