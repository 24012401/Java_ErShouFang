package lxx;

import zhw.view.LoginTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class WinMain extends JFrame {

    JLabel label;
    JButton button1, button2;
    JPanel panel1, panel2;

    public WinMain() {
        this.setLayout(new GridLayout(2, 1));

        button1 = new JButton("注册");
        button1.setBounds(1350, 210, 4, 3);
        button2 = new JButton("登录");
        button2.setBounds(1400, 210, 4, 3);
        panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel2.add(button1);
        panel2.add(button2);
        this.add(panel2);

        label = new JLabel("欢迎使用二手房交易管理系统！");
        label.setFont(new Font("宋体", Font.PLAIN, 45));
//        label.setBounds(300, 300, 700, 20);
//        this.add(label);
        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label);
        this.add(panel1);

        awtEvent(); //创建监听
    }

    private void awtEvent() {
        // 注册按钮监听
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                WinRegister winRegister = new WinRegister();
                winRegister.setTitle("用户注册");
                winRegister.setBounds(450, 200, 360, 270);
                winRegister.setVisible(true);
                winRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
            }
        });
        // 登录按钮监听
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginTest loginTest = new LoginTest();
                loginTest.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WinMain winMain = new WinMain();
                    winMain.setTitle("主界面");
                    winMain.setBounds(450, 200, 800, 500);
                    winMain.setVisible(true);
                    winMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
                } catch (Exception e) {
                    e. printStackTrace();
                }
            }
        });
    }
}
