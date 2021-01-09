import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

/**
 * author: 刘晓霞
 * function: 用户注册界面
 * time: 2021.01.09
 */

public class WinRegister extends JFrame implements ActionListener {
    private JLabel label1, label2, label3;
    private JPasswordField passwordField1, passwordField2;
    private JComboBox<String> comboBox;
    private JPanel panel1, panel2, panel3, panel4;
    private JButton button1, button2;
    Connection connection;
    Statement statement;

    public WinRegister() {

        this.setLayout(new GridLayout(4, 1));

        comboBox = new JComboBox<>();
        label1 = new JLabel("账户类型:");
        label1.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox.addItem("普通买卖方");
        comboBox.addItem("中介业务员");
        comboBox.addItem("中介管理员");
        comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label1);
        panel1.add(comboBox);
        panel1.setLocation(500, 250);
        this.add(panel1);

        label2 = new JLabel("   密码: ");
        label2.setFont(new Font("宋体", Font.PLAIN, 20));
        passwordField1 = new JPasswordField(20);
        passwordField1.setFont(new Font("宋体", Font.PLAIN, 15));
        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(label2);
        panel2.add(passwordField1);
        this.add(panel2);

        label3 = new JLabel("确认密码:");
        label3.setFont(new Font("宋体", Font.PLAIN, 20));
        passwordField2 = new JPasswordField(20);
        passwordField2.setFont(new Font("宋体", Font.PLAIN, 15));
        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(label3);
        panel3.add(passwordField2);
        this.add(panel3);

        button1 = new JButton("注册");
        button1.setFont(new Font("宋体", Font.PLAIN, 20));
        button2 = new JButton("取消");
        button2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel4.add(button1);
        panel4.add(button2);
        this.add(panel4);

        awtEvent(); //创建监听
    }

    private void awtEvent() {

        // 注册按钮监听
        button1.addActionListener((ActionListener) this);
        // 取消按钮监听
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String leixing = comboBox.getSelectedItem().toString();
        judgePassword();
        if (e.getSource() == button1) {
            try {
                this.dispose();
                if (leixing == "普通买卖方") {
                    WinRegisterMaiMai winRegisterMaiMai = new WinRegisterMaiMai();
                    winRegisterMaiMai.setTitle("注册普通买卖方");
                    winRegisterMaiMai.setBounds(400, 200, 450, 350);
                    winRegisterMaiMai.setVisible(true);
                    winRegisterMaiMai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
                }
                else if (leixing == "中介业务员") {
                    WinRegisterSMan winRegisterSMan = new WinRegisterSMan();
                    winRegisterSMan.setTitle("注册中介业务员");
                    winRegisterSMan.setBounds(400, 200, 560, 500);
                    winRegisterSMan.setVisible(true);
                    winRegisterSMan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
                }
                else if (leixing == "中介管理员") {
                    WinRegisterAdmin winRegisterAdmin = new WinRegisterAdmin();
                    winRegisterAdmin.setTitle("注册中介管理员");
                    winRegisterAdmin.setBounds(400, 200, 450, 350);
                    winRegisterAdmin.setVisible(true);
                    winRegisterAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {

            }
        }
    }

    private void judgePassword() {
        // 判断密码是否为空
        if (new String(passwordField1.getText()).isEmpty()) {
            this.dispose();
            JOptionPane.showMessageDialog(this, "密码不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            WinRegister winRegister = new WinRegister();
            winRegister.setTitle("用户注册");
            winRegister.setBounds(450, 200, 360, 270);
            winRegister.setVisible(true);
            winRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
            return;
        }
        // 判断确认密码是否为空
        if (new String(passwordField1.getText()).isEmpty()) {
            this.dispose();
            JOptionPane.showMessageDialog(this, "确认密码不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            WinRegister winRegister = new WinRegister();
            winRegister.setTitle("用户注册");
            winRegister.setBounds(450, 200, 360, 270);
            winRegister.setVisible(true);
            winRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
            return;
        }
        // 判断两次密码是否相同
        if (passwordField1.equals(passwordField2)) {
            JOptionPane.showMessageDialog(this, "两次密码不相同","警告消息",JOptionPane.WARNING_MESSAGE);
            WinRegister winRegister = new WinRegister();
            winRegister.setTitle("用户注册");
            winRegister.setBounds(450, 200, 360, 270);
            winRegister.setVisible(true);
            winRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
            return;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WinRegister winRegister = new WinRegister();
                    winRegister.setTitle("用户注册");
                    winRegister.setBounds(450, 200, 360, 270);
                    winRegister.setVisible(true);
                    winRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
                } catch (Exception e) {
                    e. printStackTrace();
                }
            }
        });
    }
}
