/*
 * Created by JFormDesigner on Mon Jan 11 21:23:20 CST 2021
 */

package zhw.view;

import zhw.SalseMan.dao.SellerDao;
import zhw.SalseMan.entity.Seller;
import zhw.util.DbUtil;
import zhw.util.StringUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author 张鸿伟
 */

public class SellerManage extends JFrame {


    public SellerManage() {
        initComponents();
    }
    /**
     * 表格行点击事件处理
     *
     * @return void
     */
    private void table1MouseClicked(MouseEvent e) {
        // TODO add your code here
        int row = this.table1.getSelectedRow();
        this.idTextField.setText(table1.getValueAt(row, 0).toString());
        this.nameTextField.setText(table1.getValueAt(row, 1).toString());
        this.telphoneTextField.setText(table1.getValueAt(row, 3).toString());
        this.numberTextField.setText(table1.getValueAt(row, 4).toString());
        String sex = table1.getValueAt(row, 2).toString();
        sex = sex.trim();
        if ("男".equals(sex)) {
            this.woman.setSelected(false);
            this.man.setSelected(true);
        } else if ("女".equals(sex)) {
            this.woman.setSelected(true);
            this.man.setSelected(false);
        }
        this.briefTextField.setText(table1.getValueAt(row, 5).toString());
    }
    /**
     * 修改事件处理
     *
     * @return void
     */
    private void updateButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        String sellerId = idTextField.getText();
        sellerId = sellerId.trim();
        if (StringUtil.isEmpty(sellerId)) {
            JOptionPane.showMessageDialog(null, "请选择要修改的记录");
            return;
        }
        String sellerName = this.nameTextField.getText();
        //sellerName = sellerName.trim();
        String  sellerTelphone= this.telphoneTextField.getText();
        //sellerTelphone = sellerTelphone.trim();
        String sellerNumber = this.numberTextField.getText();
        //sellerNumber = sellerNumber.trim();
        String sellerBrief = this.briefTextField.getText();
        //sellerBrief = sellerBrief.trim();

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
        } else {
            sellerSex = "女";
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
                fillTable(new Seller());
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
    /**
     * 填充表格
     *
     * @param seller 要筛选的业务员
     * @return void
     */
    private void fillTable(Seller seller) {
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);
        Connection conn = null;
        DbUtil dbUtil = new DbUtil();
        try {
            conn = dbUtil.getConnection();
            ResultSet resultSet = SellerDao.list(conn, seller);
            while (resultSet.next()) {
                Vector all = new Vector();
                all.add(resultSet.getString("业务员ID"));
                all.add(resultSet.getString("业务员姓名"));
                all.add(resultSet.getString("业务员性别"));
                all.add(resultSet.getString("业务员电话"));
                all.add(resultSet.getString("工号"));
                all.add(resultSet.getString("业务员简介"));
                dtm.addRow(all);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeConnection(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void resetValue() {
        this.idTextField.setText("");
        this.nameTextField.setText("");
        this.telphoneTextField.setText("");
        this.numberTextField.setText("");
        this.man.setSelected(true);
        this.briefTextField.setText("");
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String sellerName = this.ywyNameText.getText();
        String sellerId2 = this.ywyIdText.getText();
        if(!StringUtil.isEmpty(sellerId2)){
            Integer sellerId1 = Integer.valueOf(sellerId2);
            int sellerId = sellerId1.intValue();
            fillTable(new Seller(sellerName,sellerId));
        }else{
            fillTable(new Seller(sellerName));
        }
    }
    /**
     * 业务员删除事件处理
     *
     * @return void
     */
    private void deleteButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        DbUtil dbUtil = new DbUtil();
        String idText = idTextField.getText();
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "请选择要删除的记录");
            return;
        }
        int n = JOptionPane.showConfirmDialog(null, "确定要删除记录吗？");
        if (n == 0) {
            Integer idInteger = Integer.valueOf(idText);
            int id = idInteger.intValue();
            Connection connection = null;
            try {
                connection = dbUtil.getConnection();
                int deleteNum = SellerDao.delete(connection, id);
                if (deleteNum == 1) {
                    JOptionPane.showMessageDialog(null, "删除成功");
                    this.resetValue();
                    this.fillTable(new Seller());
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "删除失败");
            } finally {
                try {
                    dbUtil.closeConnection(connection);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

//    private void addActionPerformed(ActionEvent e) {
//        // TODO add your code here
//        new SellerAddFrame().setVisible(true);
//    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label7 = new JLabel();
        ywyNameText = new JTextField();
        button3 = new JButton();
        panel1 = new JPanel();
        idTextField = new JTextField();
        nameTextField = new JTextField();
        telphoneTextField = new JTextField();
        numberTextField = new JTextField();
        man = new JRadioButton();
        woman = new JRadioButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        briefTextField = new JTextField();
        updateButton = new JButton();
        deleteButton = new JButton();
        label6 = new JLabel();
        label8 = new JLabel();
        ywyIdText = new JTextField();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "ID", "\u59d3\u540d", "\u6027\u522b", "\u7535\u8bdd", "\u5de5\u53f7", "\u7b80\u4ecb"
                }
            ));
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 70, 695, 210);

        //---- label7 ----
        label7.setText("\u4e1a\u52a1\u5458\u59d3\u540d");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(45, 20), label7.getPreferredSize()));
        contentPane.add(ywyNameText);
        ywyNameText.setBounds(135, 20, 120, ywyNameText.getPreferredSize().height);

        //---- button3 ----
        button3.setText("\u67e5\u8be2");
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(555, 15), button3.getPreferredSize()));

        //======== panel1 ========
        {
            panel1.setLayout(null);
            panel1.add(idTextField);
            idTextField.setBounds(75, 15, 130, idTextField.getPreferredSize().height);
            panel1.add(nameTextField);
            nameTextField.setBounds(475, 15, 130, nameTextField.getPreferredSize().height);
            panel1.add(telphoneTextField);
            telphoneTextField.setBounds(75, 55, 180, telphoneTextField.getPreferredSize().height);
            panel1.add(numberTextField);
            numberTextField.setBounds(475, 55, 180, numberTextField.getPreferredSize().height);

            //---- man ----
            man.setText("\u7537");
            panel1.add(man);
            man.setBounds(new Rectangle(new Point(295, 10), man.getPreferredSize()));

            //---- woman ----
            woman.setText("\u5973");
            panel1.add(woman);
            woman.setBounds(new Rectangle(new Point(340, 10), woman.getPreferredSize()));

            //---- label1 ----
            label1.setText("\u6027\u522b");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(260, 15), label1.getPreferredSize()));

            //---- label2 ----
            label2.setText("ID");
            panel1.add(label2);
            label2.setBounds(35, 15, 31, label2.getPreferredSize().height);

            //---- label3 ----
            label3.setText("\u7535\u8bdd");
            panel1.add(label3);
            label3.setBounds(new Rectangle(new Point(30, 55), label3.getPreferredSize()));

            //---- label4 ----
            label4.setText("\u5de5\u53f7");
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(435, 55), label4.getPreferredSize()));

            //---- label5 ----
            label5.setText("\u59d3\u540d");
            panel1.add(label5);
            label5.setBounds(new Rectangle(new Point(435, 15), label5.getPreferredSize()));
            panel1.add(briefTextField);
            briefTextField.setBounds(65, 95, 605, 150);

            //---- updateButton ----
            updateButton.setText("\u4fee\u6539");
            updateButton.addActionListener(e -> updateButtonActionPerformed(e));
            panel1.add(updateButton);
            updateButton.setBounds(new Rectangle(new Point(155, 250), updateButton.getPreferredSize()));

            //---- deleteButton ----
            deleteButton.setText("\u5220\u9664");
            deleteButton.addActionListener(e -> deleteButtonActionPerformed(e));
            panel1.add(deleteButton);
            deleteButton.setBounds(new Rectangle(new Point(455, 250), deleteButton.getPreferredSize()));

            //---- label6 ----
            label6.setText("\u7b80\u4ecb");
            panel1.add(label6);
            label6.setBounds(new Rectangle(new Point(25, 100), label6.getPreferredSize()));

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
        panel1.setBounds(0, 280, 695, 305);

        //---- label8 ----
        label8.setText("\u4e1a\u52a1\u5458ID");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(320, 20), label8.getPreferredSize()));
        contentPane.add(ywyIdText);
        ywyIdText.setBounds(400, 20, 120, ywyIdText.getPreferredSize().height);

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
        fillTable(new Seller());
        this.man.setSelected(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label7;
    private JTextField ywyNameText;
    private JButton button3;
    private JPanel panel1;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField telphoneTextField;
    private JTextField numberTextField;
    private JRadioButton man;
    private JRadioButton woman;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField briefTextField;
    private JButton updateButton;
    private JButton deleteButton;
    private JLabel label6;
    private JLabel label8;
    private JTextField ywyIdText;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
