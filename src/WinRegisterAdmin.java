import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: 刘晓霞
 * function: 管理员注册界面
 * time: 2021.01.09
 */

public class WinRegisterAdmin extends JFrame implements ActionListener{

    public static final String REGEX_MOBILE = "^(1[3-9]\\d{9}$)";

    JLabel label1, label2, label3, label4;
    JPanel panel1, panel2, panel3, panel4;
    JTextField textField1, textField2;
    JButton button1, button2;
    Long ID;
    Connection connection;
    PreparedStatement preparedStatement;

    public WinRegisterAdmin(Long id) {
        ID = id;
//        this.setLayout(new GridLayout(3, 1));
        this.setLayout(new GridLayout(4, 1));

        //int id = SelectID.getId();
        label1 = new JLabel("管理员ID:");
        label1.setFont(new Font("宋体", Font.PLAIN, 20));
        label2 = new JLabel(String.valueOf(id));
//        label2 = new JLabel("id");
        label2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(label1);
        panel1.add(label2);
        this.add(panel1);

        label3 = new JLabel("管理员姓名:");
        label3.setFont(new Font("宋体", Font.PLAIN, 20));
        textField1 = new JTextField(20);
        textField1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.add(label3);
        panel2.add(textField1);
        this.add(panel2);

        label4 = new JLabel("  电  话:  ");
        label4.setFont(new Font("宋体", Font.PLAIN, 20));
        textField2 = new JTextField(20);
        textField2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel3.add(label4);
        panel3.add(textField2);
        this.add(panel3);

        button1 = new JButton("注册");
        button1.setFont(new Font("宋体", Font.PLAIN, 20));
        button2 = new JButton("取消");
        button2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel4.add(button1);
        panel4.add(button2);
        this.add(panel4);

        awtEvent(); //创建监听
    }

    private void awtEvent() {
        // 注册按钮监听
        button1.addActionListener((ActionListener) this);
        // 取消按钮监听
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                WinRegister winRegister = new WinRegister();
                winRegister.setTitle("用户注册");
                winRegister.setBounds(450, 200, 360, 270);
                winRegister.setVisible(true);
                winRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
            }
        });
    }

    boolean ok = true;
    public void actionPerformed(ActionEvent e) {
        try {
            judgeName();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String phone = textField2.getText();
        if (!phone.isEmpty()) {
            try {
                judgePhone();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (e.getSource() == button1 && ok) {
            try {
                this.dispose();
                connection = Link.getConnection();
                String str = "insert into Administrator(管理员ID,管理员姓名,电话) values(?,?,?)";
                preparedStatement = connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, ID.toString());
                preparedStatement.setString(2, textField1.getText());
                preparedStatement.setString(3, textField2.getText());
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
    private void judgePhone() throws SQLException {
        String str = textField2.getText();
        Pattern p = Pattern.compile(REGEX_MOBILE);
        Matcher m = p.matcher(str);
        if (m.matches() == false) {
            ok = false;
            this.dispose();
            JOptionPane.showMessageDialog(this, "非正常手机号，请重新填写！" + str, "警告信息", JOptionPane.WARNING_MESSAGE);
            newWin();
        }
    }

    private void newWin() throws SQLException {
        WinRegisterAdmin winRegisterAdmin = new WinRegisterAdmin(ID);
        winRegisterAdmin.setTitle("注册中介管理员");
        winRegisterAdmin.setBounds(400, 200, 450, 350);
        winRegisterAdmin.setVisible(true);
        winRegisterAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    WinRegisterAdmin winRegisterAdmin = new WinRegisterAdmin();
//                    winRegisterAdmin.setTitle("注册中介管理员");
//                    winRegisterAdmin.setBounds(400, 200, 450, 350);
//                    winRegisterAdmin.setVisible(true);
//                    winRegisterAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
//                } catch (Exception e) {
//                    e. printStackTrace();
//                }
//            }
//        });
//    }
}
