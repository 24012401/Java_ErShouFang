package syx.Information;

import java.awt.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jan 11 14:01:18 CST 2021
 */



/**
 * @author Brainrain
 */
public class InformSeller extends JFrame {
    public InformSeller() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        center = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        label5 = new JLabel();
        seller_name = new JLabel();
        message = new JLabel();
        sure = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(30, 30));

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout());
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setLayout(new BorderLayout());
        }
        contentPane.add(panel2, BorderLayout.WEST);

        //======== panel3 ========
        {
            panel3.setLayout(new BorderLayout());
        }
        contentPane.add(panel3, BorderLayout.EAST);

        //======== panel4 ========
        {
            panel4.setLayout(new BorderLayout());
        }
        contentPane.add(panel4, BorderLayout.SOUTH);

        //======== center ========
        {
            center.setLayout(new BorderLayout(20, 50));

            //======== panel5 ========
            {
                panel5.setLayout(new GridLayout(3, 1, 20, 20));

                //======== panel6 ========
                {
                    panel6.setLayout(new GridLayout(1, 2));

                    //---- label5 ----
                    label5.setText(bundle.getString("InformSeller.label5.text"));
                    label5.setHorizontalAlignment(SwingConstants.RIGHT);
                    panel6.add(label5);

                    //---- seller_name ----
                    seller_name.setText(bundle.getString("InformSeller.seller_name.text"));
                    panel6.add(seller_name);
                }
                panel5.add(panel6);

                //---- message ----
                message.setText(bundle.getString("InformSeller.message.text"));
                message.setHorizontalAlignment(SwingConstants.CENTER);
                panel5.add(message);

                //---- sure ----
                sure.setText(bundle.getString("InformSeller.sure.text"));
                panel5.add(sure);
            }
            center.add(panel5, BorderLayout.CENTER);
        }
        contentPane.add(center, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel center;
    private JPanel panel5;
    private JPanel panel6;
    private JLabel label5;
    private JLabel seller_name;
    private JLabel message;
    private JButton sure;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
