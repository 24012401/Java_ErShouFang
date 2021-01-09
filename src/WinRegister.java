import javax.swing.*;
import java.awt.*;

/**
 * author: 刘晓霞
 * function: 用户注册界面
 * time: 2021.01.09
 */

public class WinRegister extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JPasswordField passwordField;
    private JComboBox<String> comboBox;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton button1;
    private JButton button2;

    public WinRegister() {

        this.setLayout(new GridLayout(3, 1));

        comboBox = new JComboBox<>();
        label1 = new JLabel("账户类型:");
        label1.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox.addItem("普通买卖方");
        comboBox.addItem("中介业务员");
        comboBox.addItem("中介管理员");
        comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label1);
        panel1.add(comboBox);
        panel1.setLocation(500, 250);
        this.add(panel1);

        label2 = new JLabel("  密码: ");
        label2.setFont(new Font("宋体", Font.PLAIN, 20));
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("宋体", Font.PLAIN, 15));
        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(label2);
        panel2.add(passwordField);
        this.add(panel2);

        button1 = new JButton("注册");
        button1.setFont(new Font("宋体", Font.PLAIN, 20));
        button2 = new JButton("取消");
        button2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(button1);
        panel3.add(button2);
        this.add(panel3);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WinRegister window = new WinRegister();
                    window.setTitle("用户注册");
                    window.setBounds(450, 200, 360, 270);
                    window.setVisible(true);
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
                } catch (Exception e) {
                    e. printStackTrace();
                }
            }
        });
    }
}
