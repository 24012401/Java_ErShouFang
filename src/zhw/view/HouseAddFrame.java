/*
 * Created by JFormDesigner on Sat Jan 09 16:51:22 CST 2021
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
public class HouseAddFrame extends JFrame {
    public HouseAddFrame() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        housenameTXT = new JTextField();
        label2 = new JLabel();
        sellerTXT = new JTextField();
        label3 = new JLabel();
        man = new JRadioButton();
        woman = new JRadioButton();
        label7 = new JLabel();
        label8 = new JLabel();
        housePriceTXT = new JTextField();
        scrollPane1 = new JScrollPane();
        houseDescTXT = new JTextArea();
        label9 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        housetype = new JComboBox();

        //======== this ========
        setTitle("\u623f\u6e90\u6dfb\u52a0");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u623f\u6e90\u540d\u79f0");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(25, 25), label1.getPreferredSize()));
        contentPane.add(housenameTXT);
        housenameTXT.setBounds(90, 20, 85, housenameTXT.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5356\u5bb6");
        contentPane.add(label2);
        label2.setBounds(245, 25, 70, label2.getPreferredSize().height);
        contentPane.add(sellerTXT);
        sellerTXT.setBounds(310, 20, 130, sellerTXT.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u5356\u5bb6\u6027\u522b");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(25, 75), label3.getPreferredSize()));

        //---- man ----
        man.setText("\u7537");
        contentPane.add(man);
        man.setBounds(new Rectangle(new Point(90, 65), man.getPreferredSize()));

        //---- woman ----
        woman.setText("\u5973");
        contentPane.add(woman);
        woman.setBounds(new Rectangle(new Point(140, 65), woman.getPreferredSize()));

        //---- label7 ----
        label7.setText("\u623f\u6e90\u7c7b\u522b");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(25, 125), label7.getPreferredSize()));

        //---- label8 ----
        label8.setText("\u623f\u6e90\u4ef7\u683c");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(245, 75), label8.getPreferredSize()));
        contentPane.add(housePriceTXT);
        housePriceTXT.setBounds(310, 75, 130, housePriceTXT.getPreferredSize().height);

        //======== scrollPane1 ========
        {

            //---- houseDescTXT ----
            houseDescTXT.setLineWrap(true);
            scrollPane1.setViewportView(houseDescTXT);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(90, 175, 355, 145);

        //---- label9 ----
        label9.setText("\u623f\u6e90\u63cf\u8ff0");
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(25, 175), label9.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(80, 360), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(270, 360, 70, 30);
        contentPane.add(housetype);
        housetype.setBounds(105, 115, 340, housetype.getPreferredSize().height);

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
        setSize(481, 462);
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(man);
        buttonGroup1.add(woman);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField housenameTXT;
    private JLabel label2;
    private JTextField sellerTXT;
    private JLabel label3;
    private JRadioButton man;
    private JRadioButton woman;
    private JLabel label7;
    private JLabel label8;
    private JTextField housePriceTXT;
    private JScrollPane scrollPane1;
    private JTextArea houseDescTXT;
    private JLabel label9;
    private JButton button1;
    private JButton button2;
    private JComboBox housetype;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
