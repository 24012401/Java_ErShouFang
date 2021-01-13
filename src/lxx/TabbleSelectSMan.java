package lxx;

import zhw.SalseMan.view.SellerManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabbleSelectSMan extends JPanel {
    public TabbleSelectSMan(JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton button = new JButton("查询业务员信息");
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SellerManage sellerManage = new SellerManage();
                sellerManage.setVisible(true);
                sellerManage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //关闭窗口
            }
        });
    }
}
