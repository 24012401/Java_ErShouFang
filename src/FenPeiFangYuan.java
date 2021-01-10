import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * author: 刘晓霞
 * function: 为业务员发分配房源
 * time: 2021.01.09
 */

public class FenPeiFangYuan extends JFrame implements ActionListener {

    JLabel label1, label2;
    JTextField textField1, textField2;
    JPanel panel1, panel2, panel3;
    JButton button1, button2;
    Connection connection;
    PreparedStatement preparedStatement;

    public FenPeiFangYuan() {
        this.setLayout(new GridLayout(3, 1));

        label1 = new JLabel(" 请输入房源ID: ");
        label1.setFont(new Font("宋体", Font.PLAIN, 20));
        textField1 = new JTextField(10);
        textField1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(label1);
        panel1.add(textField1);
        this.add(panel1);

        label2 = new JLabel("请输入业务员ID: ");
        label2.setFont(new Font("宋体", Font.PLAIN, 20));
        textField2 = new JTextField(10);
        textField2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.add(label2);
        panel2.add(textField2);
        this.add(panel2);

        button1 = new JButton("确认分配");
        button1.setFont(new Font("宋体", Font.PLAIN, 20));
        button2 = new JButton("取消分配");
        button2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(button1);
        panel3.add(button2);
        this.add(panel3);

        awtEvent(); //创建监听

    }

    private void awtEvent() {
        // 分配按钮监听
        button1.addActionListener((ActionListener) this);
        // 取消按钮监听
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    boolean ok = true;
    public void actionPerformed(ActionEvent e) {

        try {
            judgeSMam();
            judgehouse();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        if (e.getSource() == button1 && ok) {
            try {
                this.dispose();
                connection = Link.getConnection();
                String str = "update House set 业务员ID = ? where 房源ID = ?";
                preparedStatement = connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, textField2.getText());
                preparedStatement.setString(2, textField1.getText());
                preparedStatement.executeQuery();
                JOptionPane.showMessageDialog(null, "分配成功！");
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                try {
                    Link.result(connection, preparedStatement);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    private void judgeSMam() throws Exception {
        try{
            Connection con = Link.getConnection();
            String str = "Select 业务员姓名 from SalseMan where 业务员ID = ?";
            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1, textField2.getText());
            ResultSet rs = ps.executeQuery();
            if (! rs.next()) {
                ok = false;
                this.dispose();
                JOptionPane.showMessageDialog(this, "无此业务员，请重新输入！", "警告信息", JOptionPane.WARNING_MESSAGE);
                newWin();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void judgehouse() throws Exception {
        try{
            Connection con = Link.getConnection();
            String str = "Select 客户ID from House where 房源ID = ?";
            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1, textField1.getText());
            ResultSet rs = ps.executeQuery();
            if (! rs.next()) {
                ok = false;
                this.dispose();
                JOptionPane.showMessageDialog(this, "无此房源，请重新输入！", "警告信息", JOptionPane.WARNING_MESSAGE);
                newWin();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void newWin() {
        FenPeiFangYuan fenPeiFangYuan = new FenPeiFangYuan();
        fenPeiFangYuan.setTitle("为业务员分配房源");
        fenPeiFangYuan.setBounds(450, 200, 360, 270);
        fenPeiFangYuan.setVisible(true);
        fenPeiFangYuan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FenPeiFangYuan fenPeiFangYuan = new FenPeiFangYuan();
                    fenPeiFangYuan.setTitle("为业务员分配房源");
                    fenPeiFangYuan.setBounds(450, 200, 360, 270);
                    fenPeiFangYuan.setVisible(true);
                    fenPeiFangYuan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
                } catch (Exception e) {
                    e. printStackTrace();
                }
            }
        });
    }
//    public static void fenPeiFangYuan(String HouseId, String SaleManId) {
//        PreparedStatement preparedStatement = null;
//
//        try {
//            Connection con = Link.getConnection();
//            preparedStatement = con.prepareStatement("update House set 客户ID = '" + SaleManId + "' where '"+ HouseId + "'");
//            ResultSet result1 = preparedStatement.executeQuery();
//            if(result1.wasNull())
//                JOptionPane.showMessageDialog(null, "结果集中无该房源");
//        } catch (ClassNotFoundException e) {
//            System.out.println("未成功加载驱动。");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("未成功打开数据库。");
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
