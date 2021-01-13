package lxx;

import javax.swing.*;
import java.awt.*;

public class TabbleAbout extends JPanel{
    public TabbleAbout(JPanel panel) {
        panel.setLayout(new GridLayout(3, 1));

        JLabel label1 = new JLabel("二手房管理系统1.0");
        label1.setFont(new Font("宋体", Font.PLAIN, 20));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label1);
        panel.add(panel1);

        JLabel label2 = new JLabel("开发者: 刘晓霞 张鸿伟 冯海毅 孙雨轩");
        label2.setFont(new Font("宋体", Font.PLAIN, 20));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(label2);
        panel.add(panel2);
    }
}
