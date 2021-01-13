/*
 * Created by JFormDesigner on Sat Jan 09 16:57:22 CST 2021
 */

package zhw.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @auther 张鸿伟
 * @date 2021/1/6 10:51:09
 * @description
 */
public class HouseTypeManageFrame extends JFrame {
    public HouseTypeManageFrame() {
        initComponents();
    }

    private void table1MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new HouseTypeAddFrame().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xiaoxia Liu
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        houseTypeNameTxt = new JTextField();
        button1 = new JButton();
        panel1 = new JPanel();
        label2 = new JLabel();
        idTxt = new JTextField();
        label3 = new JLabel();
        nameTxt = new JTextField();
        label4 = new JLabel();
        scrollPane2 = new JScrollPane();
        descTxt = new JTextArea();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        setTitle("\u623f\u6e90\u7c7b\u578b\u7ba1\u7406");
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u7f16\u53f7", "\u7c7b\u578b\u540d\u79f0", "\u63cf\u8ff0"
                }
            ));
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    table1MousePressed(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 35, 435, 200);

        //---- label1 ----
        label1.setText("\u623f\u6e90\u7c7b\u522b\u67e5\u8be2");
        contentPane.add(label1);
        label1.setBounds(10, 10, 90, 22);
        contentPane.add(houseTypeNameTxt);
        houseTypeNameTxt.setBounds(115, 5, 210, 27);

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(330, 5, 80, 30);

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u8868\u5355\u64cd\u4f5c"));
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
            new javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e"
            ,javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
            ,new java.awt.Font("Dialo\u0067",java.awt.Font.BOLD,12)
            ,java.awt.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("borde\u0072".equals(e.getPropertyName()))throw new RuntimeException()
            ;}});
            panel1.setLayout(null);

            //---- label2 ----
            label2.setText("\u7f16\u53f7");
            panel1.add(label2);
            label2.setBounds(30, 35, 55, label2.getPreferredSize().height);

            //---- idTxt ----
            idTxt.setEditable(false);
            panel1.add(idTxt);
            idTxt.setBounds(70, 35, 75, idTxt.getPreferredSize().height);

            //---- label3 ----
            label3.setText("\u623f\u6e90\u7c7b\u522b\u540d\u79f0");
            panel1.add(label3);
            label3.setBounds(185, 35, 100, label3.getPreferredSize().height);
            panel1.add(nameTxt);
            nameTxt.setBounds(270, 35, 135, nameTxt.getPreferredSize().height);

            //---- label4 ----
            label4.setText("\u63cf\u8ff0");
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(30, 75), label4.getPreferredSize()));

            //======== scrollPane2 ========
            {

                //---- descTxt ----
                descTxt.setLineWrap(true);
                scrollPane2.setViewportView(descTxt);
            }
            panel1.add(scrollPane2);
            scrollPane2.setBounds(65, 75, 340, 95);

            //---- button2 ----
            button2.setText("\u4fee\u6539");
            button2.addActionListener(e -> button2ActionPerformed(e));
            panel1.add(button2);
            button2.setBounds(new Rectangle(new Point(165, 205), button2.getPreferredSize()));

            //---- button3 ----
            button3.setText("\u5220\u9664");
            button3.addActionListener(e -> button3ActionPerformed(e));
            panel1.add(button3);
            button3.setBounds(new Rectangle(new Point(295, 205), button3.getPreferredSize()));

            //---- button4 ----
            button4.setText("\u6dfb\u52a0");
            button4.addActionListener(e -> button4ActionPerformed(e));
            panel1.add(button4);
            button4.setBounds(new Rectangle(new Point(40, 205), button4.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(15, 245, 430, 245);

        {
            // compute preferred size
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
        setSize(270, 319);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xiaoxia Liu
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JTextField houseTypeNameTxt;
    private JButton button1;
    private JPanel panel1;
    private JLabel label2;
    private JTextField idTxt;
    private JLabel label3;
    private JTextField nameTxt;
    private JLabel label4;
    private JScrollPane scrollPane2;
    private JTextArea descTxt;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
