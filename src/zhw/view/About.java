/*
 * Created by JFormDesigner on Sat Jan 09 16:38:12 CST 2021
 */

package zhw.view;

import java.awt.*;
import javax.swing.*;
/**
 * @auther 张鸿伟
 * @date 2021/1/6 10:51:09
 * @description
 */
/**
 * 关于开发者
 *
 * @return void
 */
public class About extends JFrame {
    public About() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();

        //======== this ========
        setTitle("\u5173\u4e8e");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("\u5f00\u53d1\u8005\uff1a\u5218\u6653\u971e\u3001\u5f20\u9e3f\u4f1f\u3001\u51af\u6d77\u6bc5\u3001\u5b59\u96e8\u8f69");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
        contentPane.add(label1, BorderLayout.CENTER);

        //---- label2 ----
        label2.setText("\u5f00\u53d1\u65e5\u671f\uff1a2021\u5e741\u670810\u65e5");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));
        contentPane.add(label2, BorderLayout.SOUTH);

        //---- label3 ----
        label3.setIcon(new ImageIcon("D:\\zhw\\\u5927\u4e09\u65b0\u5b66\u671f\\\u8bfe\u8bbe\\zhw\\src\\images\\author.png"));
        contentPane.add(label3, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
