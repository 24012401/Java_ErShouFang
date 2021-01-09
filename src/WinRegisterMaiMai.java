import javax.swing.*;
import java.awt.*;

/**
 * author: 刘晓霞
 * function: 普通买卖方注册界面
 * time: 2021.01.09
 */

public class WinRegisterMaiMai extends JFrame {

    JLabel label1, label2, label3, label4, label5, label6, label7;
    JTextField textField1, textField2, textField3, textField4;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
    JRadioButton radioButtonM, radioButtonF;
    JButton button1, button2;

    public WinRegisterMaiMai(){

        this.setLayout(new GridLayout(7, 1));

        //int id = SelectID.getId();
        label1 = new JLabel("客户ID:");
        label1.setFont(new Font("宋体", Font.PLAIN, 20));
        //label2 = new JLabel(String.valueOf(id));
        label2 = new JLabel("id");
        label2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(label1);
        panel1.add(label2);
        this.add(panel1);

        label3 = new JLabel("  姓名: ");
        label3.setFont(new Font("宋体", Font.PLAIN, 20));
        textField1 = new JTextField(10);
        textField1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.add(label3);
        panel2.add(textField1);
        this.add(panel2);

        label4 = new JLabel("  性别: ");
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

        label5 = new JLabel("  电话: ");
        label5.setFont(new Font("宋体", Font.PLAIN, 20));
        textField2 = new JTextField(11);
        textField2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel4.add(label5);
        panel4.add(textField2);
        this.add(panel4);

        label6 = new JLabel("身份证号:");
        label6.setFont(new Font("宋体", Font.PLAIN, 20));
        textField3 = new JTextField(18);
        textField3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel5.add(label6);
        panel5.add(textField3);
        this.add(panel5);

        label7 = new JLabel("  邮箱: ");
        label7.setFont(new Font("宋体", Font.PLAIN, 20));
        textField4 = new JTextField(20);
        textField4.setFont(new Font("宋体", Font.PLAIN, 20));
        panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel6.add(label7);
        panel6.add(textField4);
        this.add(panel6);

        button1 = new JButton("注册");
        button1.setFont(new Font("宋体", Font.PLAIN, 20));
        button2 = new JButton("取消");
        button2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel7.add(button1);
        panel7.add(button2);
        this.add(panel7);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WinRegisterMaiMai winRegisterMaiMai = new WinRegisterMaiMai();
                    winRegisterMaiMai.setTitle("注册普通买卖方");
                    winRegisterMaiMai.setBounds(400, 200, 450, 350);
                    winRegisterMaiMai.setVisible(true);
                    winRegisterMaiMai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
                } catch (Exception e) {
                    e. printStackTrace();
                }
            }
        });
    }
}
