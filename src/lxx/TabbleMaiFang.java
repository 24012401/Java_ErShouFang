package lxx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabbleMaiFang extends JPanel {
    public TabbleMaiFang(JPanel panel, String ID) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton button = new JButton("录入房源信息");
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LuRuFangYuanXinXi luRuFangYuanXinXi = new LuRuFangYuanXinXi(ID);
                luRuFangYuanXinXi.setTitle("录入房源");
                luRuFangYuanXinXi.setBounds(300, 100, 900, 700);
                luRuFangYuanXinXi.setVisible(true);
                luRuFangYuanXinXi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
}
