package lxx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabbleFenFangYuan extends JPanel {
    public TabbleFenFangYuan(JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton button = new JButton("为业务员分配房源");
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FenPeiFangYuan fenPeiFangYuan = new FenPeiFangYuan();
                fenPeiFangYuan.setTitle("为业务员分配房源");
                fenPeiFangYuan.setBounds(450, 200, 360, 270);
                fenPeiFangYuan.setVisible(true);
                fenPeiFangYuan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
}
