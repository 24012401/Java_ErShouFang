import javax.swing.*;
import java.awt.*;

/**
 * author: 刘晓霞
 * function: 管理员注册界面
 * time: 2021.01.09
 */

public class WinRegisterAdmin extends JFrame {

    JLabel label1, label2, label3, label4;
    JPanel panel1, panel2, panel3, panel4;
    JTextField textField1, textField2;
    JButton button1, button2;

    public WinRegisterAdmin() {

        this.setLayout(new GridLayout(4, 1));

        //int id = SelectID.getId();
        label1 = new JLabel("管理员ID:");
        label1.setFont(new Font("宋体", Font.PLAIN, 20));
        //label2 = new JLabel(String.valueOf(id));
        label2 = new JLabel("id");
        label2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(label1);
        panel1.add(label2);
        this.add(panel1);

        label3 = new JLabel(" 管理员姓名:");
        label3.setFont(new Font("宋体", Font.PLAIN, 20));
        textField1 = new JTextField(10);
        textField1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.add(label3);
        panel2.add(textField1);
        this.add(panel2);

        label4 = new JLabel("  电  话:  ");
        label4.setFont(new Font("宋体", Font.PLAIN, 20));
        textField2 = new JTextField(11);
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
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WinRegisterAdmin winRegisterAdmin = new WinRegisterAdmin();
                    winRegisterAdmin.setTitle("注册中介管理员");
                    winRegisterAdmin.setBounds(400, 200, 450, 350);
                    winRegisterAdmin.setVisible(true);
                    winRegisterAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
                } catch (Exception e) {
                    e. printStackTrace();
                }
            }
        });
    }
}
