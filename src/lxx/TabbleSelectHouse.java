package lxx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabbleSelectHouse extends JPanel {
    public TabbleSelectHouse(JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton button = new JButton("查询房源信息");
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Notice notice = new Notice();
//                notice.setTitle("安排看房时间");
//                notice.setBounds(450, 200, 400, 300);
//                notice.setVisible(true);
//                notice.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
}
