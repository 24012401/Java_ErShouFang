package lxx;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class TabbleSelectCustomer extends JPanel{
    SelectCustomer updateCustomer = new SelectCustomer();
    Customer customer = new Customer();
    List<Customer> list = updateCustomer.UpdateCustomer();

//    JLabel label1;
//    JTextField textField1;
//    JButton button1, button2, button3, button4;
//    static JTable table;
//    JScrollPane scrollPane;
//    JPanel panel1, panel2;
//    DefaultTableModel defaultTableModel;

    public TabbleSelectCustomer(JPanel panel) throws Exception {

        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton button = new JButton("查询客户信息");
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WinSelectCustomer updateCostomer = null;
                try {
                    updateCostomer = new WinSelectCustomer();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                updateCostomer.setTitle("查询客户信息");
                updateCostomer.setBounds(450, 200, 800, 500);
                updateCostomer.setVisible(true);
                updateCostomer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //关闭窗口
            }
        });

//        label1 = new JLabel("请输入客户ID:");
//        label1.setFont(new Font("宋体", Font.PLAIN, 20));
//        textField1 = new JTextField(10);
//        textField1.setFont(new Font("宋体", Font.PLAIN, 20));
//        button1 = new JButton("查询");
//        button1.setFont(new Font("宋体", Font.PLAIN, 20));
//        panel1 = new JPanel();
//        panel1.add(label1);
//        panel1.add(textField1);
//        panel1.add(button1);
//        panel.add(panel1, BorderLayout.NORTH);
//
//        table = new JTable();
//        scrollPane = new JScrollPane(table);
//        defaultTableModel = new DefaultTableModel();
//        table.setModel(defaultTableModel);
//        defaultTableModel.addColumn("客户ID");
//        defaultTableModel.addColumn("姓名");
//        defaultTableModel.addColumn("性别");
//        defaultTableModel.addColumn("电话");
//        defaultTableModel.addColumn("身份证号");
//        defaultTableModel.addColumn("邮箱");
//
//        // 添加数据
//        for (int i = 0; i < list.size(); i ++) {
//            Vector<Object> data = new Vector<Object>();
//            data.add(list.get(i).getId());
//            data.add(list.get(i).getName());
//            data.add(list.get(i).getSex());
//            data.add(list.get(i).getPhone());
//            data.add(list.get(i).getCard());
//            data.add(list.get(i).getMail());
//            defaultTableModel.addRow(data);
//        }
//        // 添加空表格
//        for (int i = 0; i < list.size(); i++) {
//            Vector<Object> data = new Vector<Object>();
//            data.add(null);
//            data.add(null);
//            data.add(null);
//            data.add(null);
//            data.add(null);
//            data.add(null);
//            defaultTableModel.addRow(data);
//        }
//        panel.add(scrollPane, BorderLayout.CENTER);
//
//        button2 = new JButton("刷新");
//        button2.setFont(new Font("宋体", Font.PLAIN, 20));
//        button3 = new JButton("修改");
//        button3.setFont(new Font("宋体", Font.PLAIN, 20));
//        button4 = new JButton("返回");
//        button4.setFont(new Font("宋体", Font.PLAIN, 20));
//        panel2 = new JPanel();
//        panel2.add(button2);
//        panel2.add(button3);
//        panel2.add(button4);
//        panel.add(panel2, BorderLayout.SOUTH);
//        panel.setVisible(true);
//
//        button2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try{
////                    dispose();
////                    newWin();
//                } catch (Exception exception) {
//                    exception.printStackTrace();
//                }
//            }
//        });
//
//        // 修改按钮
//        button3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    WinUpdateCustomer winUpdateCustomer = new WinUpdateCustomer();
//                    winUpdateCustomer.setTitle("修改客户信息");
//                    winUpdateCustomer.setBounds(400, 200, 450, 350);
//                    winUpdateCustomer.setVisible(true);
//                    winUpdateCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//
//            }
//        });
//
//        // 查询按钮
//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String[] str = new String[0];
//                try {
//                    str = updateCustomer.select(textField1.getText());
//                } catch (Exception exception) {
//                    exception.printStackTrace();
//                }
//                defaultTableModel.setRowCount(0);
//                Vector<Object> data = new Vector<Object>();
//                data.add(str[0]);
//                data.add(str[1]);
//                data.add(str[2]);
//                data.add(str[3]);
//                data.add(str[4]);
//                data.add(str[5]);
//                defaultTableModel.addRow(data);
//            }
//        });
//
//        // 返回按钮
//        button4.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                defaultTableModel.setRowCount(0);
//                // 添加数据
//                for (int i = 0; i < list.size(); i ++) {
//                    Vector<Object> data = new Vector<Object>();
//                    data.add(list.get(i).getId());
//                    data.add(list.get(i).getName());
//                    data.add(list.get(i).getSex());
//                    data.add(list.get(i).getPhone());
//                    data.add(list.get(i).getCard());
//                    data.add(list.get(i).getMail());
//                    defaultTableModel.addRow(data);
//                }
//                // 添加空表格
//                for (int i = 0; i < list.size(); i++) {
//                    Vector<Object> data = new Vector<Object>();
//                    data.add(null);
//                    data.add(null);
//                    data.add(null);
//                    data.add(null);
//                    data.add(null);
//                    data.add(null);
//                    defaultTableModel.addRow(data);
//                }
//            }
//        });

    }
}
