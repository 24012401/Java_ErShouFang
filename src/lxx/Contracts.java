package lxx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Integer;

public class Contracts extends JFrame implements ActionListener {

    String CHECK_DATE = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|"
            +"((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|"
            +"((0[48]|[2468][048]|[3579][26])00))-02-29)$";

    JLabel label1, label2, label3, label4, label5, label6, label7, label8;
    JTextField textField1, textField2, textField3, textField4, textField5, textField6;
    JComboBox<String> comboBox;
    JButton button1, button2;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
    Connection connection;
    PreparedStatement preparedStatement;

    public Contracts() {
        this.setLayout(new GridLayout(9, 1));

        label1 = new JLabel("买家ID:");
        label1.setFont(new Font("宋体", Font.PLAIN, 20));
        textField1 = new JTextField(10);
        textField1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(label1);
        panel1.add(textField1);
        this.add(panel1);

        label2 = new JLabel("房源ID:");
        label2.setFont(new Font("宋体", Font.PLAIN, 20));
        textField2 = new JTextField(10);
        textField2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.add(label2);
        panel2.add(textField2);
        this.add(panel2);

        label3 = new JLabel("定金数额:");
        label3.setFont(new Font("宋体", Font.PLAIN, 20));
        textField3 = new JTextField(20);
        textField3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel3.add(label3);
        panel3.add(textField3);
        this.add(panel3);

        label4 = new JLabel("剩余房款:");
        label4.setFont(new Font("宋体", Font.PLAIN, 20));
        textField4 = new JTextField(20);
        textField4.setFont(new Font("宋体", Font.PLAIN, 20));
        panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel4.add(label4);
        panel4.add(textField4);
        this.add(panel4);

        label5 = new JLabel("签约日期:");
        label5.setFont(new Font("宋体", Font.PLAIN, 20));
        panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel5.add(label5);
        this.add(panel5);

        label6 = new JLabel("      年:");
        label6.setFont(new Font("宋体", Font.PLAIN, 20));
        textField5 = new JTextField(10);
        textField5.setFont(new Font("宋体", Font.PLAIN, 20));
        panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel6.add(label6);
        panel6.add(textField5);
        this.add(panel6);

        label7 = new JLabel("      月:");
        label7.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox = new JComboBox<String>();
        comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox.addItem("01");
        comboBox.addItem("02");
        comboBox.addItem("03");
        comboBox.addItem("04");
        comboBox.addItem("05");
        comboBox.addItem("06");
        comboBox.addItem("07");
        comboBox.addItem("08");
        comboBox.addItem("09");
        comboBox.addItem("10");
        comboBox.addItem("11");
        comboBox.addItem("12");
        panel7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel7.add(label7);
        panel7.add(comboBox);
        this.add(panel7);

        label8 = new JLabel("      日:");
        label8.setFont(new Font("宋体", Font.PLAIN, 20));
        textField6 = new JTextField(10);
        textField6.setFont(new Font("宋体", Font.PLAIN, 20));
        panel8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel8.add(label8);
        panel8.add(textField6);
        this.add(panel8);

        button1 = new JButton("确定");
        button1.setFont(new Font("宋体", Font.PLAIN, 20));
        button2 = new JButton("取消");
        button2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel9 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel9.add(button1);
        panel9.add(button2);
        this.add(panel9);

        // 添加监听
        awtEvent();
    }

    private void awtEvent() {
        button1.addActionListener((ActionListener) this);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    boolean ok = true;
    public void actionPerformed(ActionEvent e) {
        String time = textField5.getText()+"-"+comboBox.getSelectedItem().toString()+"-"+textField6.getText();
        try {
            judgeCustomer();
            judgeHouse();
            judgeMoney();
            judgeDate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        if (e.getSource() == button1 && ok) {
            try {
                connection = Link.getConnection();
                String str = "insert into Contracts (买家ID,房源ID,定金数额,剩余房款,签约日期) values(?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, textField1.getText());
                preparedStatement.setString(2, textField2.getText());
                preparedStatement.setString(3, textField3.getText());
                preparedStatement.setString(4, textField4.getText());
                preparedStatement.setString(5, time);
                preparedStatement.executeQuery();
                JOptionPane.showMessageDialog(null, "添加成功！");
                dispose();
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

    private void judgeHouse() {
        try{
            Connection con = Link.getConnection();
            String str = "Select * from House where 房源ID = ?";
            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1, textField2.getText());
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

    private void judgeCustomer() {
        try{
            Connection con = Link.getConnection();
            String str = "Select * from Customer where 客户ID = ?";
            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1, textField1.getText());
            ResultSet rs = ps.executeQuery();
            if (! rs.next()) {
                ok = false;
                this.dispose();
                JOptionPane.showMessageDialog(this, "无此客户，请重新输入！", "警告信息", JOptionPane.WARNING_MESSAGE);
                newWin();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void judgeMoney() {
        int money = Integer.parseInt(textField3.getText());
        int rest = Integer.parseInt(textField4.getText());
        if (money < rest) {
            ok = false;
            this.dispose();
            JOptionPane.showMessageDialog(this, "剩余房款大于定金数额，请重新填写！", "警告信息", JOptionPane.WARNING_MESSAGE);
            newWin();
        }
    }

    private void judgeDate() {
        String str = textField5.getText()+"-"+comboBox.getSelectedItem().toString()+"-"+textField6.getText();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");   //设置日期格式
        String now = df.format(new Date());   // new Date()为获取当前系统时间
        Pattern p = Pattern.compile(CHECK_DATE);
        Matcher m = p.matcher(str);
        if (m.matches() == false || now.compareTo(str) < 0) {
            if (str.equals(now)) {
                return;
            }
            ok = false;
            this.dispose();
            JOptionPane.showMessageDialog(this, "非正常日期或日期在当前日期之后，请重新填写！", "警告信息", JOptionPane.WARNING_MESSAGE);
            newWin();
        }
    }

    private void newWin() {
        Contracts contracts = new Contracts();
        contracts.setTitle("添加合同信息");
        contracts.setBounds(450, 200, 560, 420);
        contracts.setVisible(true);
        contracts.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Contracts contracts = new Contracts();
                    contracts.setTitle("添加合同信息");
                    contracts.setBounds(450, 200, 560, 420);
                    contracts.setVisible(true);
                    contracts.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //退出程序
                } catch (Exception e) {
                    e. printStackTrace();
                }
            }
        });
    }
}
