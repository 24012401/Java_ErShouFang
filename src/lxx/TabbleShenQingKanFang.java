package lxx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TabbleShenQingKanFang extends JPanel implements ActionListener {
    JLabel label, label1, label2;
    JTextField textField1, textField2;
    JButton button1, button2;
    JPanel panel1, panel2, panel3;
    Connection connection;
    PreparedStatement preparedStatement;
    String ID;

    public TabbleShenQingKanFang(JPanel panel, String id) {

//        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        ID = id;
        label = new JLabel("您的ID为:");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        label1 = new JLabel(id);
        label1.setFont(new Font("宋体", Font.PLAIN, 20));
//        textField1 = new JTextField(10);
//        textField1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(label);
        panel1.add(label1);
        panel.add(panel1);

        label2 = new JLabel("请输入您要查看的房源ID:");
        label2.setFont(new Font("宋体", Font.PLAIN, 20));
        textField2 = new JTextField(10);
        textField2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.add(label2);
        panel2.add(textField2);
        panel.add(panel2);

        button1 = new JButton("确定");
        button1.setFont(new Font("宋体", Font.PLAIN, 20));
        button2 = new JButton("取消");
        button2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(button1);
        panel3.add(button2);
        panel.add(panel3);

        // 添加监听
        awtEvent();
    }

    private void awtEvent() {
        button1.addActionListener((ActionListener) this);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                textField1.setText("");
                textField2.setText("");
            }
        });
    }

    boolean ok = true;
    public void actionPerformed(ActionEvent e) {
        try {
//            judgeCustomer();
            judgeHouse();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        if (e.getSource() == button1 && ok) {
            try {
                connection = Link.getConnection();
                String str = "insert into ApplyHouse(客户ID, 房源ID, 是否申请看房) values(?,?,1)";
                preparedStatement = connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, ID);
                preparedStatement.setString(2, textField2.getText());
                preparedStatement.executeQuery();
                JOptionPane.showMessageDialog(null, "申请成功！看房日期请于3个工作日后自行查看！");
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

    private void judgeHouse() {
        try{
            Connection con = Link.getConnection();
            String str = "Select * from House where 房源ID = ?";
            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1, textField2.getText());
            ResultSet rs = ps.executeQuery();
            if (! rs.next()) {
                ok = false;
//                this.dispose();
                JOptionPane.showMessageDialog(this, "无此房源，请重新输入！", "警告信息", JOptionPane.WARNING_MESSAGE);
//                newWin();
                textField2.setText("");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    private void judgeCustomer() {
//        try{
//            Connection con = Link.getConnection();
//            String str = "Select * from Customer where 客户ID = ?";
//            PreparedStatement ps = con.prepareStatement(str);
//            ps.setString(1, textField1.getText());
//            ResultSet rs = ps.executeQuery();
//            if (! rs.next()) {
//                ok = false;
////                this.dispose();
//                JOptionPane.showMessageDialog(this, "无此客户，请重新输入！", "警告信息", JOptionPane.WARNING_MESSAGE);
////                newWin();
//                textField1.setText("");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void newWin() {
//        ShenQingKanFang shenQingKanFang = new ShenQingKanFang();
//        shenQingKanFang.setTitle("申请看房");
//        shenQingKanFang.setBounds(450, 200, 400, 300);
//        shenQingKanFang.setVisible(true);
//        shenQingKanFang.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
//    }
//
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    ShenQingKanFang shenQingKanFang = new ShenQingKanFang();
//                    shenQingKanFang.setTitle("申请看房");
//                    shenQingKanFang.setBounds(450, 200, 400, 300);
//                    shenQingKanFang.setVisible(true);
//                    shenQingKanFang.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
//                } catch (Exception e) {
//                    e. printStackTrace();
//                }
//            }
//        });
//    }
}
