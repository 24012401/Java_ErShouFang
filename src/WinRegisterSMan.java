import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: 刘晓霞
 * function: 业务员注册界面
 * time: 2021.01.09
 */

public class WinRegisterSMan extends JFrame implements ActionListener {
    public static final String REGEX_MOBILE = "^(1[3-9]\\d{9}$)";
    public static final String REGEX_CARD = "\\d{8}$";

    JLabel label1, label2, label3, label4, label5, label6, label7;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
    JTextField textField, textField1, textField2, textField3;
    JRadioButton radioButtonM, radioButtonF;
    JTextArea textArea;
    JButton button1, button2;
    JScrollPane scrollPane;
    Connection connection;
    PreparedStatement preparedStatement;
    Long ID;

    public WinRegisterSMan(Long id) {
        ID = id;
//        this.setLayout(new GridLayout(7, 1));
        this.setLayout(new GridLayout(8, 1));

        //int id = SelectID.getId();
        label1 = new JLabel("业务员ID:");
        label1.setFont(new Font("宋体", Font.PLAIN, 20));
        label2 = new JLabel(String.valueOf(id));
//        label2 = new JLabel("id");
        label2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(label1);
        panel1.add(label2);
        this.add(panel1);

        label3 = new JLabel("业务员姓名:");
        label3.setFont(new Font("宋体", Font.PLAIN, 20));
        textField1 = new JTextField(20);
        textField1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.add(label3);
        panel2.add(textField1);
        this.add(panel2);

        label4 = new JLabel("业务员性别: ");
        label4.setFont(new Font("宋体", Font.PLAIN, 20));
        radioButtonM = new JRadioButton("男");
        radioButtonM.setFont(new Font("宋体", Font.PLAIN, 20));
        radioButtonF = new JRadioButton("女");
        radioButtonF.setFont(new Font("宋体", Font.PLAIN, 20));
        panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel3.add(label4);
        panel3.add(radioButtonF);
        panel3.add(radioButtonM);
        this.add(panel3);

        label5 = new JLabel("业务员电话: ");
        label5.setFont(new Font("宋体", Font.PLAIN, 20));
        textField2 = new JTextField(20);
        textField2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel4.add(label5);
        panel4.add(textField2);
        this.add(panel4);

        label6 = new JLabel("  工  号: ");
        label6.setFont(new Font("宋体", Font.PLAIN, 20));
        textField3 = new JTextField(20);
        textField3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel5.add(label6);
        panel5.add(textField3);
        this.add(panel5);

        label7 = new JLabel("业务员简介: ");
        label7.setFont(new Font("宋体", Font.PLAIN, 20));
        panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel6.add(label7);
        this.add(panel6);

        textArea = new JTextArea(10, 20);
        textArea.setFont(new Font("宋体", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
//        panel7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        panel7.add(textArea);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//        panel9 = new JPanel();
//        panel9.add(scrollPane);
//        this.add(panel7);
//        this.add(panel9);
        this.add(scrollPane);

        button1 = new JButton("注册");
        button1.setFont(new Font("宋体", Font.PLAIN, 20));
        button2 = new JButton("取消");
        button2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel8.add(button1);
        panel8.add(button2);
        this.add(panel8);

        awtEvent(); //创建监听
    }

    private void awtEvent() {
        // 监听单选框（互斥），选择性别
        radioButtonM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButtonM.isSelected()){
                    radioButtonF.setSelected(false);
                }
            }
        });
        radioButtonF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButtonF.isSelected()){
                    radioButtonM.setSelected(false);
                }
            }
        });

        // 注册按钮监听
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
        // 获取性别
        String sex = null;
        try {
            judgeName();
            judgeSex(sex);
            judgePhone();
            judgeCard();
            judgeIntroduction();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (e.getSource() == button1 && ok) {
            try {
                this.dispose();
                connection = Link.getConnection();
                String str = "insert into SalseMan(业务员ID,业务员姓名,业务员性别,业务员电话,工号,业务员简介) values(?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, ID.toString());
                preparedStatement.setString(2, textField1.getText());
                preparedStatement.setString(3, sex);
                preparedStatement.setString(4, textField2.getText());
                preparedStatement.setString(5, textField3.getText());
                preparedStatement.setString(6, textArea.getText());
                preparedStatement.executeQuery();
                JOptionPane.showMessageDialog(null, "注册成功！");
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

    private void judgeName() throws SQLException {
        String str = textField1.getText();
        if (str.isEmpty()) {
            ok = false;
            this.dispose();
            JOptionPane.showMessageDialog(this, "名字不能为空，请重新填写！", "警告信息", JOptionPane.WARNING_MESSAGE);
            newWin();
        }
    }

    private void judgeSex(String sex) throws SQLException {
        if (radioButtonF.isSelected()) {
            sex = "女";
        }
        else if (radioButtonM.isSelected()){
            sex = "男";
        }
        if (sex == null) {
            ok = false;
            this.dispose();
            JOptionPane.showMessageDialog(this, "性别不能为空，请重新选择！", "警告信息", JOptionPane.WARNING_MESSAGE);
            newWin();
        }
    }

    private void judgePhone() throws SQLException {
        String str = textField2.getText();
        Pattern p = Pattern.compile(REGEX_MOBILE);
        Matcher m = p.matcher(str);
        if (m.matches() == false) {
            ok = false;
            this.dispose();
            JOptionPane.showMessageDialog(this, "非正常手机号，请重新填写！", "警告信息", JOptionPane.WARNING_MESSAGE);
            newWin();
        }
    }
    private void judgeCard() throws SQLException {
        String str = textField3.getText();
        if (str.matches(REGEX_CARD) == false) {
            ok = false;
            this.dispose();
            JOptionPane.showMessageDialog(this, "非正常工号，请重新填写！", "警告信息", JOptionPane.WARNING_MESSAGE);
            newWin();
        }
    }

    private void judgeIntroduction() throws SQLException {
        String str = textArea.getText();
        if (str.isEmpty()) {
            ok = false;
            this.dispose();
            JOptionPane.showMessageDialog(this, "个人简介不能为空，请重新填写！", "警告信息", JOptionPane.WARNING_MESSAGE);
            newWin();
        }
    }

    private void newWin() throws SQLException {
        WinRegisterSMan winRegisterSMan = new WinRegisterSMan(ID);
        winRegisterSMan.setTitle("注册中介业务员");
        winRegisterSMan.setBounds(400, 200, 560, 500);
        winRegisterSMan.setVisible(true);
        winRegisterSMan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    WinRegisterSMan winRegisterSMan = new WinRegisterSMan();
//                    winRegisterSMan.setTitle("注册中介业务员");
//                    winRegisterSMan.setBounds(400, 200, 560, 500);
//                    winRegisterSMan.setVisible(true);
//                    winRegisterSMan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
//                } catch (Exception e) {
//                    e. printStackTrace();
//                }
//            }
//        });
//    }
}
