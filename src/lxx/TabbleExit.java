package lxx;

import zhw.view.LoginTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabbleExit extends JPanel{

    JButton button1, button2;
//    JMenuItem menuItem1, menuItem2;
    public TabbleExit(JPanel panel, JFrame frame) {
//        panel.setLayout(new GridLayout(1, 1));
//        menuItem1 = new JMenuItem("注销登录");
//        menuItem2 = new JMenuItem("退出系统");
//        panel.add(menuItem1);
//        panel.add(menuItem2);
//
        panel.setLayout(new GridLayout(3, 1));

        button1 = new JButton("注销登录");
        button1.setFont(new Font("宋体", Font.PLAIN, 20));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(button1);
        panel.add(panel1);

        button2 = new JButton("退出系统");
        button2.setFont(new Font("宋体", Font.PLAIN, 20));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(button2);
        panel.add(panel2);

        awtEvent(frame); //创建监听
    }

    private void awtEvent(JFrame frame) {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                dispose();
//                TabbleExit.super.setVisible(false);
                frame.dispose();
                LoginTest loginTest = new LoginTest();
                loginTest.setVisible(true);
//                System.exit(0);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                dispose();
//                TabbleExit.super.setVisible(false);
                frame.dispose();
                WinMain winMain = new WinMain();
                winMain.setTitle("主界面");
                winMain.setBounds(450, 200, 800, 500);
                winMain.setVisible(true);
                winMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
//                System.exit(0);
            }
        });
    }
}
