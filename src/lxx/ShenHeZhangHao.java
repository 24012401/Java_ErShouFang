package lxx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ShenHeZhangHao extends JPanel implements ActionListener {

    JLabel label1;
    JTextField textField1;
    JPanel panel1, panel2;
    JButton button1, button2;
    Connection connection;
    PreparedStatement preparedStatement;

    public ShenHeZhangHao(JPanel panel) {
        panel.setLayout(new GridLayout(3, 1));

        label1 = new JLabel("请输入要授权的业务员ID:");
        label1.setFont(new Font("宋体", Font.PLAIN, 20));
        textField1 = new JTextField(10);
        textField1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(label1);
        panel1.add(textField1);
        panel.add(panel1);

        button1 = new JButton("授权");
        button1.setFont(new Font("宋体", Font.PLAIN, 20));
        button2 = new JButton("取消");
        button2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(button1);
        panel2.add(button2);
        panel.add(panel2);

        awtEvent(); //创建监听
    }

    private void awtEvent() {
        // 授权按钮监听
        button1.addActionListener((ActionListener) this);
        // 取消按钮监听
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
            }
        });
    }

    boolean ok = true;
    public void actionPerformed(ActionEvent e) {
        try {
            judgeID();
            judgeFalse();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        if (e.getSource() == button1 && ok) {
            try {
                connection = Link.getConnection();
                String str = "update Users set 是否同意该账户使用=? where 账户ID=?";
                preparedStatement = connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, "true");
                preparedStatement.setString(2, textField1.getText());
                preparedStatement.executeQuery();
                JOptionPane.showMessageDialog(null, "授权成功！");
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                try {
                    Link.result(connection, preparedStatement);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    private void judgeFalse() {
        try{
            Connection con = Link.getConnection();
            String str = "Select * from Users where 账户ID=?";
            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1, textField1.getText());
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getString("是否同意该账户使用").equals("1")) {
                ok = false;
                JOptionPane.showMessageDialog(this, "该账户已授权!", "警告信息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void judgeID() throws Exception {
        try{
            Connection con = Link.getConnection();
            String str = "Select * from SalseMan where 业务员ID = ?";
            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1, textField1.getText());
            ResultSet rs = ps.executeQuery();
            if (! rs.next()) {
                ok = false;
                JOptionPane.showMessageDialog(this, "无此业务员，请重新输入！", "警告信息", JOptionPane.WARNING_MESSAGE);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
