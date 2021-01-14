package syx.Information;

import java.awt.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jan 11 14:25:38 CST 2021
 */



/**
 * @author Brainrain
 */
public class InformUser extends JFrame {
    public InformUser() {
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
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();

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
                panel5.setLayout(new GridLayout(3, 1, 20, 20));

                //======== panel6 ========
                {
                    panel6.setLayout(new GridLayout(1, 2));

                    //---- label1 ----
                    label1.setText(bundle.getString("InformUser.label1.text_2"));
                    label1.setHorizontalAlignment(SwingConstants.RIGHT);
                    panel6.add(label1);

                    //---- label2 ----
                    label2.setText(bundle.getString("InformUser.label2.text"));
                    panel6.add(label2);
                }
                panel5.add(panel6);

                //---- label3 ----
                label3.setText(bundle.getString("InformUser.label3.text_2"));
                label3.setHorizontalAlignment(SwingConstants.CENTER);
                panel5.add(label3);

                //---- button1 ----
                button1.setText(bundle.getString("InformUser.button1.text"));
                panel5.add(button1);
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
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
