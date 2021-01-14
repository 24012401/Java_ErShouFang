package syx.Information;

import java.awt.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jan 11 14:32:34 CST 2021
 */



/**
 * @author Brainrain
 */
public class InformBuyer extends JFrame {
    public InformBuyer() {
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
        label1 = new JLabel();
        buyer_name = new JLabel();
        panel7 = new JPanel();
        label3 = new JLabel();
        house_id = new JLabel();
        label6 = new JLabel();
        time = new JLabel();
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
            center.setLayout(new BorderLayout());

            //======== panel5 ========
            {
                panel5.setLayout(new GridLayout(3, 1));

                //======== panel6 ========
                {
                    panel6.setLayout(new GridLayout(1, 2));

                    //---- label1 ----
                    label1.setText(bundle.getString("InformBuyer.label1.text"));
                    label1.setHorizontalAlignment(SwingConstants.RIGHT);
                    panel6.add(label1);

                    //---- buyer_name ----
                    buyer_name.setText(bundle.getString("InformBuyer.buyer_name.text"));
                    panel6.add(buyer_name);
                }
                panel5.add(panel6);

                //======== panel7 ========
                {
                    panel7.setLayout(new GridLayout(1, 4));

                    //---- label3 ----
                    label3.setText(bundle.getString("InformBuyer.label3.text"));
                    label3.setHorizontalAlignment(SwingConstants.CENTER);
                    panel7.add(label3);

                    //---- house_id ----
                    house_id.setText(bundle.getString("InformBuyer.house_id.text"));
                    house_id.setHorizontalAlignment(SwingConstants.CENTER);
                    panel7.add(house_id);

                    //---- label6 ----
                    label6.setText(bundle.getString("InformBuyer.label6.text"));
                    panel7.add(label6);

                    //---- time ----
                    time.setText(bundle.getString("InformBuyer.time.text"));
                    panel7.add(time);
                }
                panel5.add(panel7);

                //---- sure ----
                sure.setText(bundle.getString("InformBuyer.sure.text"));
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
    private JLabel label1;
    private JLabel buyer_name;
    private JPanel panel7;
    private JLabel label3;
    private JLabel house_id;
    private JLabel label6;
    private JLabel time;
    private JButton sure;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
