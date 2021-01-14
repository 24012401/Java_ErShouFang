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

public class LuRuFangYuanXinXi extends JFrame implements ActionListener {

    JLabel label, label1, label2, label3, label4, label5, label6, label7,label8, label9, label10;
    JLabel label11, label12, label13, label14, label15, label16, label17, label18, label19, label20;
    JLabel label21, label22, label23, label24, label25, label26, label27, label28, label29, label30, label31;

    JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7,textField8, textField9, textField10;
    JTextField textField11, textField12, textField13, textField14, textField15, textField16, textField17, textField18, textField19, textField20;
    JTextField textField21, textField22, textField23, textField24, textField25, textField26, textField27, textField28, textField29;

    JComboBox<String> comboBox, comboBox1, comboBox2, comboBox3, comboBox4, comboBox5,comboBox6,comboBox7, comboBox8, comboBox9;

    JButton button1, button2;

    JPanel panel, panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9, panel10;
    JPanel panel11, panel12, panel13, panel14, panel15, panel16, panel17, panel18, panel19, panel20;
    JPanel panel21, panel22, panel23, panel24, panel25, panel26, panel27, panel28, panel29, panel30, panel31;

    JScrollPane scrollPane;

    Connection connection;
    PreparedStatement preparedStatement;

    String CHECK_DATE = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|"
            +"((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|"
            +"((0[48]|[2468][048]|[3579][26])00))-02-29)$";

    String ID;
    ResultSet id_House;

    public LuRuFangYuanXinXi(String id) {
        this.setLayout(new GridLayout(1, 1));
        ID = id;

        panel = new JPanel(new GridLayout(30, 1));
        scrollPane = new JScrollPane(panel);

        label = new JLabel("   客户ID:");
        label1 = new JLabel(id);
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(label);
        panel1.add(label1);
        panel.add(panel1);

        label2 = new JLabel("       售价:");
        textField1 = new JTextField(20);
        panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.add(label2);
        panel2.add(textField1);
        panel.add(panel2);

        label3 = new JLabel("室内面积:");
        textField2 = new JTextField(20);
        panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel3.add(label3);
        panel3.add(textField2);
        panel.add(panel3);

        label4 = new JLabel("        房型:");
        comboBox1 = new JComboBox<>();
        comboBox1.addItem("普通单元式住宅");
        comboBox1.addItem("公寓式住宅");
        comboBox1.addItem("复式住宅");
        comboBox1.addItem("跃层式住宅");
        comboBox1.addItem("花园洋房式住宅");
        comboBox1.addItem("小户式住宅");
        panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel4.add(label4);
        panel4.add(comboBox1);
        panel.add(panel4);

        label5 = new JLabel("房源名称:");
        textField3 = new JTextField(20);
        panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel5.add(label5);
        panel5.add(textField3);
        panel.add(panel5);

        label6 = new JLabel("        楼层:");
        textField4 = new JTextField(20);
        panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel6.add(label6);
        panel6.add(textField4);
        panel.add(panel6);

        label7 = new JLabel("        朝向:");
        comboBox2 = new JComboBox<>();
        comboBox2.addItem("北");
        comboBox2.addItem("南");
        comboBox2.addItem("西");
        comboBox2.addItem("东");
        comboBox2.addItem("东北");
        comboBox2.addItem("东南");
        comboBox2.addItem("西北");
        comboBox2.addItem("西南");
        panel7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel7.add(label7);
        panel7.add(comboBox2);
        panel.add(panel7);

        label8 = new JLabel("        装修:");
        comboBox3 = new JComboBox<>();
        comboBox3.addItem("经济型");
        comboBox3.addItem("中档型");
        comboBox3.addItem("高档型");
        comboBox3.addItem("豪华型");
        panel8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel8.add(label8);
        panel8.add(comboBox3);
        panel.add(panel8);

        label9 = new JLabel("        楼型:");
        comboBox4 = new JComboBox<>();
        comboBox4.addItem("板楼");
        comboBox4.addItem("塔楼");
        comboBox4.addItem("板塔结合");
        panel9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel9.add(label9);
        panel9.add(comboBox4);
        panel.add(panel9);

        label10 = new JLabel("供暖方式:");
        comboBox5 = new JComboBox<>();
        comboBox5.addItem("集中式供暖");
        comboBox5.addItem("家用燃煤锅炉");
        comboBox5.addItem("热冷风式空调机");
        comboBox5.addItem("家用中央空调系统");
        comboBox5.addItem("家用电锅炉");
        comboBox5.addItem("电热膜采暖");
        comboBox5.addItem("热水地面采暖");
        comboBox5.addItem("分户壁挂式燃气采暖");
        panel10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel10.add(label10);
        panel10.add(comboBox5);
        panel.add(panel10);

        label11 = new JLabel("        采光:");
        comboBox6 = new JComboBox<>();
        comboBox6.addItem("侧窗采光");
        comboBox6.addItem("天窗采光");
        comboBox6.addItem("混合采光");
        panel11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel11.add(label11);
        panel11.add(comboBox6);
        panel.add(panel11);

        label12 = new JLabel("建筑年代:");
//        textField5 = new JTextField(20);
        panel12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel12.add(label12);
//        panel12.add(textField5);
        panel.add(panel12);

        label29 = new JLabel("            年:");
        textField18 = new JTextField(10);
        panel29 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel29.add(label29);
        panel29.add(textField18);
        panel.add(panel29);

        label30 = new JLabel("            月:");
        comboBox = new JComboBox<String>();
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
        panel30 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel30.add(label30);
        panel30.add(comboBox);
        panel.add(panel30);

        label31 = new JLabel("            日:");
        textField19 = new JTextField(10);
        panel31 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel31.add(label31);
        panel31.add(textField19);
        panel.add(panel31);

        label13 = new JLabel("        税费:");
        textField6 = new JTextField(20);
        panel13 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel13.add(label13);
        panel13.add(textField6);
        panel.add(panel13);

        label14 = new JLabel("        小区:");
        textField7 = new JTextField(20);
        panel14 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel14.add(label14);
        panel14.add(textField7);
        panel.add(panel14);

        label15 = new JLabel("        电梯:");
        comboBox7 = new JComboBox<>();
        comboBox7.addItem("有");
        comboBox7.addItem("无");
        panel15 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel15.add(label15);
        panel15.add(comboBox7);
        panel.add(panel15);

        label16 = new JLabel("产权性质:");
        comboBox8 = new JComboBox<>();
        comboBox8.addItem("国有房产");
        comboBox8.addItem("私有房产");
        comboBox8.addItem("集体所有房产");
        comboBox8.addItem("股份制企业房产");
        comboBox8.addItem("联营企业房产");
        comboBox8.addItem("港、澳、台胞房产");
        comboBox8.addItem("涉外房产");
        comboBox8.addItem("其他房产");
        panel16 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel16.add(label16);
        panel16.add(comboBox8);
        panel.add(panel16);

        label17 = new JLabel("        首付:");
        textField8 = new JTextField(20);
        panel17 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel17.add(label17);
        panel17.add(textField8);
        panel.add(panel17);

        label18 = new JLabel("核心卖点:");
        textField9 = new JTextField(20);
        panel18 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel18.add(label18);
        panel18.add(textField9);
        panel.add(panel18);

        label19 = new JLabel("业主心态:");
        textField10 = new JTextField(20);
        panel19 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel19.add(label19);
        panel19.add(textField10);
        panel.add(panel19);

        label20 = new JLabel("适宜人群:");
        textField11 = new JTextField(20);
        panel20 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel20.add(label20);
        panel20.add(textField11);
        panel.add(panel20);

        label28 = new JLabel("在售情况:");
//        textField12 = new JTextField(20);
        comboBox9 = new JComboBox<>();
        comboBox9.addItem("在售");
        comboBox9.addItem("不售");
        comboBox9.addItem("已售");
        panel28 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel28.add(label28);
        panel28.add(comboBox9);
        panel.add(panel28);

        label22 = new JLabel("            省:");
        textField13 = new JTextField(20);
        panel22 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel22.add(label22);
        panel22.add(textField13);
        panel.add(panel22);

        label23 = new JLabel("            市:");
        textField14 = new JTextField(20);
        panel23 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel23.add(label23);
        panel23.add(textField14);
        panel.add(panel23);

        label24 = new JLabel("            区:");
        textField15 = new JTextField(20);
        panel24 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel24.add(label24);
        panel24.add(textField15);
        panel.add(panel24);

        label25 = new JLabel("        街道:");
        textField16 = new JTextField(20);
        panel25 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel25.add(label25);
        panel25.add(textField16);
        panel.add(panel25);

        label26 = new JLabel("        具体:");
        textField17 = new JTextField(20);
        panel26 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel26.add(label26);
        panel26.add(textField17);
        panel.add(panel26);

        button1 = new JButton("确定");
        button2 = new JButton("取消");
        panel27 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel27.add(button1);
        panel27.add(button2);
        panel.add(panel27);

        this.add(scrollPane);

        awtEvent(); //创建监听
    }

    private void awtEvent() {

        // 确定按钮监听
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
        String time = textField18.getText()+"-"+comboBox.getSelectedItem().toString()+"-"+textField19.getText();
        judgeNull();
        judgeDate();
        if (e.getSource() == button1 && ok) {
            try {
                this.dispose();
                connection = Link.getConnection();
                String str = "insert into House(客户ID, 售价, 室内面积, 房型, 房源名称, 楼层, 朝向, 装修," +
                        "楼型, 供暖方式, 采光, 建筑年代, 税费, 小区, 电梯, 产权性质, 首付, 核心卖点," +
                        "业主心态, 适宜人群, 在售情况, 省, 市, 区, 街道, 具体)" +
                        "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, ID);
                preparedStatement.setString(2, textField1.getText());
                preparedStatement.setString(3, textField2.getText());
                preparedStatement.setString(4, comboBox1.getSelectedItem().toString());
                preparedStatement.setString(5, textField3.getText());
                preparedStatement.setString(6, textField4.getText());
                preparedStatement.setString(7, comboBox2.getSelectedItem().toString());
                preparedStatement.setString(8, comboBox3.getSelectedItem().toString());
                preparedStatement.setString(9, comboBox4.getSelectedItem().toString());
                preparedStatement.setString(10, comboBox5.getSelectedItem().toString());
                preparedStatement.setString(11, comboBox6.getSelectedItem().toString());
                preparedStatement.setString(12, time);
                preparedStatement.setString(13, textField6.getText());
                preparedStatement.setString(14, textField7.getText());
                preparedStatement.setString(15, comboBox7.getSelectedItem().toString());
                preparedStatement.setString(16, comboBox8.getSelectedItem().toString());
                preparedStatement.setString(17, textField8.getText());
                preparedStatement.setString(18, textField9.getText());
                preparedStatement.setString(19, textField10.getText());
                preparedStatement.setString(20, textField11.getText());
                preparedStatement.setString(21, comboBox9.getSelectedItem().toString());
                preparedStatement.setString(22, textField13.getText());
                preparedStatement.setString(23, textField14.getText());
                preparedStatement.setString(24, textField15.getText());
                preparedStatement.setString(25, textField16.getText());
                preparedStatement.setString(26, textField17.getText());
                preparedStatement.executeUpdate();
                // 获取系统自动生成的id
                id_House = preparedStatement.getGeneratedKeys();
                id_House.next();
                Long ID_House = id_House.getLong(1);
                JOptionPane.showMessageDialog(null, "录入成功!您的账号ID为: " + ID_House);
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                try {
                    Link.result(connection, preparedStatement);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    private void judgeDate() {
        String str = textField18.getText()+"-"+comboBox.getSelectedItem().toString()+"-"+textField19.getText();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");   //设置日期格式
        String now = df.format(new Date());   // new Date()为获取当前系统时间
        Pattern p = Pattern.compile(CHECK_DATE);
        Matcher m = p.matcher(str);
        if (m.matches() == false || now.compareTo(str) < 0) {
            if (str.equals(now)) {
                return;
            }
            ok = false;
            JOptionPane.showMessageDialog(this, "非正常日期或日期在当前日期之后，请重新填写！", "警告信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void judgeNull() {
        if (textField1.getText().equals("")||textField2.getText().equals("")||textField3.getText().equals("")||textField4.getText().equals("")||
                textField6.getText().equals("")||textField7.getText().equals("")||textField8.getText().equals("")||
                textField9.getText().equals("")||textField10.getText().equals("")||textField11.getText().equals("")|| textField13.getText().equals("")||
                textField14.getText().equals("")||textField15.getText().equals("")|| textField16.getText().equals("")||textField17.getText().equals("")) {
            ok = false;
            JOptionPane.showMessageDialog(this, "表中仍有内容为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void newWin() {
        LuRuFangYuanXinXi luRuFangYuanXinXi = new LuRuFangYuanXinXi("2");
        luRuFangYuanXinXi.setTitle("录入房源");
        luRuFangYuanXinXi.setBounds(300, 100, 900, 700);
        luRuFangYuanXinXi.setVisible(true);
        luRuFangYuanXinXi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    newWin();
                } catch (Exception e) {
                    e. printStackTrace();
                }
            }
        });
    }
}
