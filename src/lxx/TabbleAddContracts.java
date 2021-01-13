package lxx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TabbleAddContracts extends JPanel {

    public TabbleAddContracts(JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton button = new JButton("添加合同信息");
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contracts contracts = new Contracts();
                contracts.setTitle("添加合同信息");
                contracts.setBounds(450, 200, 560, 420);
                contracts.setVisible(true);
                contracts.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
}
