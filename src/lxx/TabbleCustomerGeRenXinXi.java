package lxx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TabbleCustomerGeRenXinXi extends JPanel implements ActionListener {

    JLabel label1, label2, label3, label4, label5, label6;
    JButton button1;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
    Connection connection;
    PreparedStatement preparedStatement;

    public TabbleCustomerGeRenXinXi(JPanel panel, String ID) throws Exception {
        panel.setLayout(new GridLayout(8, 1));

        try {
            connection = Link.getConnection();
            String sql = "select * from Customer where 客户ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                label1 = new JLabel("     您的ID为: " + resultSet.getString("客户ID"));
                label1.setFont(new Font("宋体", Font.PLAIN, 20));
                label2 = new JLabel("   您的姓名为: " + resultSet.getString("姓名"));
                label2.setFont(new Font("宋体", Font.PLAIN, 20));
                label3 = new JLabel("   您的性别为: " + resultSet.getString("性别"));
                label3.setFont(new Font("宋体", Font.PLAIN, 20));
                label4 = new JLabel("   您的电话为: " + resultSet.getString("电话"));
                label4.setFont(new Font("宋体", Font.PLAIN, 20));
                label5 = new JLabel("您的身份证号为: " + resultSet.getString("身份证号"));
                label5.setFont(new Font("宋体", Font.PLAIN, 20));
                label6 = new JLabel("   您的邮箱为: " + resultSet.getString("邮箱"));
                label6.setFont(new Font("宋体", Font.PLAIN, 20));
            }
            panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel1.add(label1);
            panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel2.add(label2);
            panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel3.add(label3);
            panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel4.add(label4);
            panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel5.add(label5);
            panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel6.add(label6);
            panel.add(panel1);
            panel.add(panel2);
            panel.add(panel3);
            panel.add(panel4);
            panel.add(panel5);
            panel.add(panel6);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                Link.result(connection, preparedStatement);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        button1 = new JButton("修改");
        button1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel7.add(button1);
        panel.add(panel7);

        awtEvent(); //创建监听
    }

    private void awtEvent() {
        button1.addActionListener((ActionListener) this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            WinUpdateCustomer winUpdateCustomer = null;
            try {
                winUpdateCustomer = new WinUpdateCustomer();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            winUpdateCustomer.setTitle("修改客户信息");
            winUpdateCustomer.setBounds(400, 200, 450, 350);
            winUpdateCustomer.setVisible(true);
            winUpdateCustomer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // 关闭当前窗口
        }
    }
}
