/*
 * Created by JFormDesigner on Sat Jan 09 17:19:30 CST 2021
 */

package zhw.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @auther 张鸿伟
 * @date 2021/1/6 10:51:09
 * @description
 */
public class HouseTypeAddFrame extends JFrame {
    public HouseTypeAddFrame() {
        initComponents();
    }

    private void thisWindowClosing(WindowEvent e) {
        // TODO add your code here
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label3 = new JLabel();
        label4 = new JLabel();
        houseTypeNameTxt = new JTextField();
        scrollPane1 = new JScrollPane();
        houseTypeDescTxt = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u623f\u6e90\u7c7b\u522b\u6dfb\u52a0");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label3 ----
        label3.setText("\u623f\u6e90\u7c7b\u522b\u540d\u79f0");
        contentPane.add(label3);
        label3.setBounds(25, 45, 110, 25);

        //---- label4 ----
        label4.setText("\u623f\u6e90\u7c7b\u522b\u63cf\u8ff0");
        contentPane.add(label4);
        label4.setBounds(25, 90, 80, label4.getPreferredSize().height);
        contentPane.add(houseTypeNameTxt);
        houseTypeNameTxt.setBounds(160, 50, 155, houseTypeNameTxt.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(houseTypeDescTxt);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(160, 95, 155, 130);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(55, 285), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(190, 285), button2.getPreferredSize()));

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(367, 401);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label3;
    private JLabel label4;
    private JTextField houseTypeNameTxt;
    private JScrollPane scrollPane1;
    private JTextArea houseTypeDescTxt;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
