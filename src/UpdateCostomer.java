import java.sql.*;
import javax.swing.*;

/**
 * author: 刘晓霞
 * function: 更新客户信息功能实现
 * time: 2021.01.09
 */

public class UpdateCostomer {
    public static void getId(String str, String shuxing, String zhi) {
        PreparedStatement preparedStatement = null;
        Link link = new Link();

        try {
            Connection con = link.linker();
            preparedStatement = con.prepareStatement("update Custom set" +shuxing+ "= '" +zhi+"' where 客户ID = '"+str+"'" );
            ResultSet result1 = preparedStatement.executeQuery();
            if(result1.wasNull())
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
    }
}
