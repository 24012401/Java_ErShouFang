import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * author: 刘晓霞
 * function: 为业务员发分配房源
 * time: 2021.01.09
 */

public class FenPeiFangYuan extends JFrame {

    JLabel label1, label2;
    JTextField textField1, textField2;
    JPanel panel1, panel2, panel3;
    JButton button1, button2;

    public FenPeiFangYuan() {
        this.setLayout(new GridLayout(3, 1));

        label1 = new JLabel(" 请输入房源ID: ");
        label1.setFont(new Font("宋体", Font.PLAIN, 20));
        textField1 = new JTextField(10);
        textField1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(label1);
        panel1.add(textField1);
        this.add(panel1);

        label2 = new JLabel("请输入业务员ID: ");
        label2.setFont(new Font("宋体", Font.PLAIN, 20));
        textField2 = new JTextField(10);
        textField2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.add(label2);
        panel2.add(textField2);
        this.add(panel2);

        button1 = new JButton("确认分配");
        button1.setFont(new Font("宋体", Font.PLAIN, 20));
        button2 = new JButton("取消分配");
        button2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(button1);
        panel3.add(button2);
        this.add(panel3);

    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FenPeiFangYuan fenPeiFangYuan = new FenPeiFangYuan();
                    fenPeiFangYuan.setTitle("为业务员分配房源");
                    fenPeiFangYuan.setBounds(450, 200, 360, 270);
                    fenPeiFangYuan.setVisible(true);
                    fenPeiFangYuan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
                } catch (Exception e) {
                    e. printStackTrace();
                }
            }
        });
    }
//    public static void fenPeiFangYuan(String HouseId, String SaleManId) {
//        PreparedStatement preparedStatement = null;
//
//        try {
//            Connection con = Link.getConnection();
//            preparedStatement = con.prepareStatement("update House set 客户ID = '" + SaleManId + "' where '"+ HouseId + "'");
//            ResultSet result1 = preparedStatement.executeQuery();
//            if(result1.wasNull())
//                JOptionPane.showMessageDialog(null, "结果集中无该房源");
//        } catch (ClassNotFoundException e) {
//            System.out.println("未成功加载驱动。");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("未成功打开数据库。");
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
