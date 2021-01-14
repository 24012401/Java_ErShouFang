/*
 * Created by JFormDesigner on Thu Jan 14 10:12:24 CST 2021
 */

package zhw.view;

import zhw.dao.SellerDao;
import zhw.SalseMan.entity.Seller;
import zhw.util.DbUtil;
import zhw.util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Brainrain
 */
public class SellerUpdateFrame extends JFrame {
    public SellerUpdateFrame() {
        initComponents();
    }

    private void resetValue() {
        this.sellerIDTXT.setText("");
        this.sellerNameTXT.setText("");
        this.telephoneTXT.setText("");
        this.numberTXT.setText("");
        this.man.setSelected(true);
        this.sellerDescTXT.setText("");
    }
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String sellerId = sellerIDTXT.getText();
        sellerId = sellerId.trim();
        if (StringUtil.isEmpty(sellerId)) {
            JOptionPane.showMessageDialog(null, "请选择要修改的记录");
            return;
        }
        String sellerName = this.sellerNameTXT.getText();
        String  sellerTelphone= this.telephoneTXT.getText();
        String sellerNumber = this.numberTXT.getText();
        String sellerBrief = this.sellerDescTXT.getText();

        if (StringUtil.isEmpty(sellerName)) {
            JOptionPane.showMessageDialog(null, "业务员姓名不能为空");
            return;
        }
        if (StringUtil.isEmpty(sellerTelphone)) {
            JOptionPane.showMessageDialog(null, "业务员电话号码不能为空");
            return;
        }
        if (StringUtil.isEmpty(sellerNumber)) {
            JOptionPane.showMessageDialog(null, "业务员工号不能为空");
            return;
        }
        String sellerSex;
        if (this.man.isSelected()) {
            sellerSex = "男";
            this.woman.setSelected(false);
        } else {
            sellerSex = "女";
            this.man.setSelected(false);
        }
        DbUtil dbUtil = new DbUtil();
        Integer sellerInteger = Integer.valueOf(sellerId);
        int sellerIdInt = sellerInteger.intValue();
        Seller seller = new Seller(sellerIdInt,sellerName,sellerSex,sellerTelphone,sellerNumber,sellerBrief);
        Connection conn = null;
        try {
            conn = dbUtil.getConnection();
            int addNum = SellerDao.update(conn, seller);
            if (addNum == 1) {
                JOptionPane.showMessageDialog(null, "修改成功");
                resetValue();
            } else {
                JOptionPane.showMessageDialog(null, "修改失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "修改失败");
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        resetValue();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xiaoxia Liu
        label1 = new JLabel();
        sellerNameTXT = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        man = new JRadioButton();
        woman = new JRadioButton();
        label7 = new JLabel();
        numberTXT = new JTextField();
        scrollPane1 = new JScrollPane();
        sellerDescTXT = new JTextArea();
        label9 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        telephoneTXT = new JTextField();
        sellerIDTXT = new JTextField();
        label4 = new JLabel();

        //======== this ========
        setTitle("\u4e1a\u52a1\u5458\u4fee\u6539");
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4e1a\u52a1\u5458\u59d3\u540d");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(25, 20), label1.getPreferredSize()));
        contentPane.add(sellerNameTXT);
        sellerNameTXT.setBounds(90, 20, 85, sellerNameTXT.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u4e1a\u52a1\u5458\u5de5\u53f7");
        contentPane.add(label2);
        label2.setBounds(245, 20, 70, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u4e1a\u52a1\u5458\u6027\u522b");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(25, 75), label3.getPreferredSize()));

        //---- man ----
        man.setText("\u7537");
        contentPane.add(man);
        man.setBounds(new Rectangle(new Point(95, 70), man.getPreferredSize()));

        //---- woman ----
        woman.setText("\u5973");
        contentPane.add(woman);
        woman.setBounds(new Rectangle(new Point(140, 70), woman.getPreferredSize()));

        //---- label7 ----
        label7.setText("\u4e1a\u52a1\u5458\u7535\u8bdd");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(25, 125), label7.getPreferredSize()));
        contentPane.add(numberTXT);
        numberTXT.setBounds(310, 20, 130, numberTXT.getPreferredSize().height);

        //======== scrollPane1 ========
        {

            //---- sellerDescTXT ----
            sellerDescTXT.setLineWrap(true);
            scrollPane1.setViewportView(sellerDescTXT);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(90, 175, 355, 145);

        //---- label9 ----
        label9.setText("\u4e1a\u52a1\u5458\u7b80\u4ecb");
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(25, 175), label9.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(80, 360), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(270, 360, 70, 30);
        contentPane.add(telephoneTXT);
        telephoneTXT.setBounds(120, 125, 160, telephoneTXT.getPreferredSize().height);
        contentPane.add(sellerIDTXT);
        sellerIDTXT.setBounds(310, 80, 130, sellerIDTXT.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u4e1a\u52a1\u5458ID");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(245, 80), label4.getPreferredSize()));

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
        setSize(505, 445);
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(man);
        buttonGroup1.add(woman);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xiaoxia Liu
    private JLabel label1;
    private JTextField sellerNameTXT;
    private JLabel label2;
    private JLabel label3;
    private JRadioButton man;
    private JRadioButton woman;
    private JLabel label7;
    private JTextField numberTXT;
    private JScrollPane scrollPane1;
    private JTextArea sellerDescTXT;
    private JLabel label9;
    private JButton button1;
    private JButton button2;
    private JTextField telephoneTXT;
    private JTextField sellerIDTXT;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
