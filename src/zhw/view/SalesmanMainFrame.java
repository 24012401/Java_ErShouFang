/*
 * Created by JFormDesigner on Sat Jan 09 21:54:02 CST 2021
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
public class SalesmanMainFrame extends JFrame {
    public SalesmanMainFrame() {
        initComponents();
    }

    private void thisWindowClosing(WindowEvent e) {
        // TODO add your code here
    }

    private void menuItem6ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void menuItem7ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void menuItem8ActionPerformed(ActionEvent e) {
        // TODO add your code here
        About about = new About();
        about.setVisible(true);
    }

    private void menuItem1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.setVisible(false);
        new LoginTest().setVisible(true);
    }

    private void menuItem4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
        System.out.println(result);
        if (result == 0) {
            System.exit(1);
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void table1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void updateButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void delButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar2 = new JMenuBar();
        menu3 = new JMenu();
        menuItem6 = new JMenuItem();
        menu6 = new JMenu();
        menuItem7 = new JMenuItem();
        menu4 = new JMenu();
        menuItem8 = new JMenuItem();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem4 = new JMenuItem();
        panel1 = new JPanel();
        label1 = new JLabel();
        houseNameTXT = new JTextField();
        label12 = new JLabel();
        sellerTXT = new JTextField();
        label13 = new JLabel();
        houseType = new JComboBox();
        button2 = new JButton();
        scrollPane3 = new JScrollPane();
        table2 = new JTable();
        panel4 = new JPanel();
        label14 = new JLabel();
        idTXT2 = new JTextField();
        label15 = new JLabel();
        BookNameTXT2 = new JTextField();
        label16 = new JLabel();
        priceTXT2 = new JTextField();
        label17 = new JLabel();
        bookauthorTXT2 = new JTextField();
        label18 = new JLabel();
        man2 = new JRadioButton();
        woman2 = new JRadioButton();
        label19 = new JLabel();
        typeCB2 = new JComboBox();
        label20 = new JLabel();
        scrollPane4 = new JScrollPane();
        bookDescTXT2 = new JTextArea();
        updateButton2 = new JButton();
        delButton2 = new JButton();

        //======== this ========
        setTitle("\u4e3b\u754c\u9762");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar2 ========
        {

            //======== menu3 ========
            {
                menu3.setText("\u623f\u6e90\u7c7b\u522b\u64cd\u4f5c");

                //---- menuItem6 ----
                menuItem6.setText("\u623f\u6e90\u7c7b\u522b\u7ba1\u7406");
                menuItem6.addActionListener(e -> menuItem6ActionPerformed(e));
                menu3.add(menuItem6);
            }
            menuBar2.add(menu3);

            //======== menu6 ========
            {
                menu6.setText("\u623f\u6e90\u7ba1\u7406");

                //---- menuItem7 ----
                menuItem7.setText("\u623f\u6e90\u6dfb\u52a0");
                menuItem7.addActionListener(e -> menuItem7ActionPerformed(e));
                menu6.add(menuItem7);
            }
            menuBar2.add(menu6);

            //======== menu4 ========
            {
                menu4.setText("\u5173\u4e8e");

                //---- menuItem8 ----
                menuItem8.setText("\u5173\u4e8e\u5f00\u53d1\u8005");
                menuItem8.addActionListener(e -> menuItem8ActionPerformed(e));
                menu4.add(menuItem8);
            }
            menuBar2.add(menu4);

            //======== menu1 ========
            {
                menu1.setText("\u7528\u6237");

                //---- menuItem1 ----
                menuItem1.setText("\u6ce8\u9500");
                menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
                menu1.add(menuItem1);

                //---- menuItem4 ----
                menuItem4.setText("\u5b89\u5168\u9000\u51fa");
                menuItem4.addActionListener(e -> menuItem4ActionPerformed(e));
                menu1.add(menuItem4);
            }
            menuBar2.add(menu1);
        }
        setJMenuBar(menuBar2);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u623f\u6e90\u540d\u79f0");
            panel1.add(label1);
            label1.setBounds(20, 35, 60, label1.getPreferredSize().height);
            panel1.add(houseNameTXT);
            houseNameTXT.setBounds(75, 35, 125, houseNameTXT.getPreferredSize().height);

            //---- label12 ----
            label12.setText("\u5356\u5bb6");
            panel1.add(label12);
            label12.setBounds(260, 35, 30, label12.getPreferredSize().height);
            panel1.add(sellerTXT);
            sellerTXT.setBounds(295, 35, 90, sellerTXT.getPreferredSize().height);

            //---- label13 ----
            label13.setText("\u623f\u6e90\u7c7b\u522b");
            panel1.add(label13);
            label13.setBounds(new Rectangle(new Point(435, 35), label13.getPreferredSize()));
            panel1.add(houseType);
            houseType.setBounds(490, 30, 131, houseType.getPreferredSize().height);

            //---- button2 ----
            button2.setText("\u67e5\u8be2");
            button2.addActionListener(e -> button1ActionPerformed(e));
            panel1.add(button2);
            button2.setBounds(670, 30, 90, button2.getPreferredSize().height);

            { // compute preferred size
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
        panel1.setBounds(15, 10, 790, 90);

        //======== scrollPane3 ========
        {

            //---- table2 ----
            table2.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u7f16\u53f7", "\u623f\u6e90\u540d\u79f0", "\u5356\u5bb6", "\u5356\u5bb6\u6027\u522b", "\u623f\u6e90\u7c7b\u522b", "\u63cf\u8ff0", "\u4ef7\u683c"
                }
            ));
            table2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                    table1MouseClicked(e);
                }
            });
            scrollPane3.setViewportView(table2);
        }
        contentPane.add(scrollPane3);
        scrollPane3.setBounds(15, 120, 790, 175);

        //======== panel4 ========
        {
            panel4.setLayout(null);

            //---- label14 ----
            label14.setText("\u7f16\u53f7");
            panel4.add(label14);
            label14.setBounds(new Rectangle(new Point(45, 20), label14.getPreferredSize()));

            //---- idTXT2 ----
            idTXT2.setEditable(false);
            panel4.add(idTXT2);
            idTXT2.setBounds(80, 20, 100, idTXT2.getPreferredSize().height);

            //---- label15 ----
            label15.setText("\u623f\u6e90\u540d\u79f0");
            panel4.add(label15);
            label15.setBounds(265, 20, 55, label15.getPreferredSize().height);
            panel4.add(BookNameTXT2);
            BookNameTXT2.setBounds(320, 20, 130, BookNameTXT2.getPreferredSize().height);

            //---- label16 ----
            label16.setText("\u4ef7\u683c");
            panel4.add(label16);
            label16.setBounds(530, 20, 35, label16.getPreferredSize().height);
            panel4.add(priceTXT2);
            priceTXT2.setBounds(565, 20, 85, priceTXT2.getPreferredSize().height);

            //---- label17 ----
            label17.setText("\u5356\u5bb6");
            panel4.add(label17);
            label17.setBounds(new Rectangle(new Point(45, 75), label17.getPreferredSize()));
            panel4.add(bookauthorTXT2);
            bookauthorTXT2.setBounds(80, 75, 95, bookauthorTXT2.getPreferredSize().height);

            //---- label18 ----
            label18.setText("\u5356\u5bb6\u6027\u522b");
            panel4.add(label18);
            label18.setBounds(new Rectangle(new Point(265, 75), label18.getPreferredSize()));

            //---- man2 ----
            man2.setText("\u7537");
            panel4.add(man2);
            man2.setBounds(new Rectangle(new Point(325, 70), man2.getPreferredSize()));

            //---- woman2 ----
            woman2.setText("\u5973");
            panel4.add(woman2);
            woman2.setBounds(new Rectangle(new Point(370, 70), woman2.getPreferredSize()));

            //---- label19 ----
            label19.setText("\u623f\u6e90\u7c7b\u522b");
            panel4.add(label19);
            label19.setBounds(new Rectangle(new Point(530, 75), label19.getPreferredSize()));
            panel4.add(typeCB2);
            typeCB2.setBounds(595, 70, 115, typeCB2.getPreferredSize().height);

            //---- label20 ----
            label20.setText("\u623f\u6e90\u63cf\u8ff0");
            panel4.add(label20);
            label20.setBounds(new Rectangle(new Point(45, 130), label20.getPreferredSize()));

            //======== scrollPane4 ========
            {

                //---- bookDescTXT2 ----
                bookDescTXT2.setLineWrap(true);
                scrollPane4.setViewportView(bookDescTXT2);
            }
            panel4.add(scrollPane4);
            scrollPane4.setBounds(105, 130, 605, 150);

            //---- updateButton2 ----
            updateButton2.setText("\u4fee\u6539");
            updateButton2.addActionListener(e -> updateButtonActionPerformed(e));
            panel4.add(updateButton2);
            updateButton2.setBounds(165, 300, 135, 30);

            //---- delButton2 ----
            delButton2.setText("\u5220\u9664");
            delButton2.addActionListener(e -> delButtonActionPerformed(e));
            panel4.add(delButton2);
            delButton2.setBounds(425, 300, 135, 30);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel4.getComponentCount(); i++) {
                    Rectangle bounds = panel4.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel4.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel4.setMinimumSize(preferredSize);
                panel4.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel4);
        panel4.setBounds(15, 310, 790, 350);

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
        setSize(831, 751);
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(man2);
        buttonGroup1.add(woman2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar2;
    private JMenu menu3;
    private JMenuItem menuItem6;
    private JMenu menu6;
    private JMenuItem menuItem7;
    private JMenu menu4;
    private JMenuItem menuItem8;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem4;
    private JPanel panel1;
    private JLabel label1;
    private JTextField houseNameTXT;
    private JLabel label12;
    private JTextField sellerTXT;
    private JLabel label13;
    private JComboBox houseType;
    private JButton button2;
    private JScrollPane scrollPane3;
    private JTable table2;
    private JPanel panel4;
    private JLabel label14;
    private JTextField idTXT2;
    private JLabel label15;
    private JTextField BookNameTXT2;
    private JLabel label16;
    private JTextField priceTXT2;
    private JLabel label17;
    private JTextField bookauthorTXT2;
    private JLabel label18;
    private JRadioButton man2;
    private JRadioButton woman2;
    private JLabel label19;
    private JComboBox typeCB2;
    private JLabel label20;
    private JScrollPane scrollPane4;
    private JTextArea bookDescTXT2;
    private JButton updateButton2;
    private JButton delButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
