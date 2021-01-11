/*
 * Created by JFormDesigner on Sat Jan 09 17:30:35 CST 2021
 */

package zhw.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @auther 张鸿伟
 * @date 2021/1/6 10:51:09
 * @description
 */
public class ImageInsertFrm extends JFrame {
    public ImageInsertFrm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        layeredPane1 = new JLayeredPane();
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== layeredPane1 ========
        {

            //---- label1 ----
            label1.setIcon(new ImageIcon("D:\\zhw\\\u5927\u4e09\u65b0\u5b66\u671f\\\u8bfe\u8bbe\\zhw\\src\\images\\bg700-530.png"));
            layeredPane1.add(label1, JLayeredPane.DEFAULT_LAYER);
            label1.setBounds(0, 5, 700, 520);
        }
        contentPane.add(layeredPane1);
        layeredPane1.setBounds(0, -55, 700, 525);

        //---- button1 ----
        button1.setText("text");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(0, 475), button1.getPreferredSize()));

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
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public static void main(String[] args){
        new ImageInsertFrm().setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLayeredPane layeredPane1;
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
