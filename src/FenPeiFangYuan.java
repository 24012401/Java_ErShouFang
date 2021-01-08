import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * author: 刘晓霞
 * function: 为业务员发分配房源功能实现
 * time: 2021.01.09
 */

public class FenPeiFangYuan {
    public static void fenPeiFangYuan(String HouseId, String SaleManId) {
        Link link = new Link();
        PreparedStatement preparedStatement = null;

        try {
            Connection con = link.linker();
            preparedStatement = con.prepareStatement("update House set 客户ID = '" + SaleManId + "' where '"+ HouseId + "'");
            ResultSet result1 = preparedStatement.executeQuery();
            if(result1.wasNull())
                JOptionPane.showMessageDialog(null, "结果集中无该房源");
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
