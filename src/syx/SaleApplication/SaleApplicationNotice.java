package syx.SaleApplication;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Jan 10 23:32:03 CST 2021
 */


/**
 * @author Brainrain
 */
public class SaleApplicationNotice extends JFrame {
    ActionListener listener=new SaleApplicationNoticeListen();
    public static void main(String[] args){
        SaleApplicationNotice san = new SaleApplicationNotice();
        san.setBounds(100,100,450,260);
        san.setTitle("测试");
    }
    public SaleApplicationNotice() {
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        center = new JPanel();
        panel9 = new JPanel();
        label2 = new JLabel();
        panel10 = new JPanel();
        sure = new JButton();
        exit = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(30, 30));

        //======== panel4 ========
        {
            panel4.setLayout(new BorderLayout());
        }
        contentPane.add(panel4, BorderLayout.NORTH);

        //======== panel5 ========
        {
            panel5.setLayout(new BorderLayout());
        }
        contentPane.add(panel5, BorderLayout.WEST);

        //======== panel6 ========
        {
            panel6.setLayout(new BorderLayout());
        }
        contentPane.add(panel6, BorderLayout.EAST);

        //======== panel7 ========
        {
            panel7.setLayout(new BorderLayout());
        }
        contentPane.add(panel7, BorderLayout.SOUTH);

        //======== center ========
        {
            center.setLayout(new BorderLayout());

            //======== panel9 ========
            {
                panel9.setLayout(new GridLayout(1, 1));

                //---- label2 ----
                label2.setText(bundle.getString("SaleApplicationNotice.label2.text"));
                label2.setHorizontalAlignment(SwingConstants.CENTER);
                panel9.add(label2);
            }
            center.add(panel9, BorderLayout.CENTER);

            //======== panel10 ========
            {
                panel10.setLayout(new GridLayout(1, 2));

                //---- sure ----
                sure.setText(bundle.getString("SaleApplicationNotice.sure.text"));
                panel10.add(sure);
                sure.addActionListener(listener);

                //---- exit ----
                exit.setText(bundle.getString("SaleApplicationNotice.exit.text"));
                panel10.add(exit);
            }
            center.add(panel10, BorderLayout.SOUTH);
        }
        contentPane.add(center, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel center;
    private JPanel panel9;
    private JLabel label2;
    private JPanel panel10;
    private JButton sure;
    private JButton exit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
