package lxx;

import javax.swing.*;
import java.awt.*;

/**
 * author: 刘晓霞
 * function: 利用选项卡组件实现类似网页的客户功能界面
 * time: 2021/1/12
 */

public class WinCustomer extends JPanel {

    String ID;
//    JButton button;

    public WinCustomer(String id, JFrame frame) throws Exception {
        super(new GridLayout(1, 1));
        ID = id;
        JTabbedPane tabbedPane1 = new JTabbedPane();
//        JPanel panel = new JPanel(); // 查看个人信息
//        JPanel panel1 = new JPanel(); // 查询房源
//        JPanel panel2 = new JPanel(); // 申请看房
//        JPanel panel3 = new JPanel(); // 申请卖房
//        JPanel panel4 = new JPanel(); // 查询业务员信息
//        JPanel panel5 = new JPanel(); // 关于
//        JPanel panel6 = new JPanel(); // 退出登录
        JPanel panel = createPanel(frame); // 查看个人信息
        JPanel panel1 = createPanel1(); // 查询房源
        Component panel2 = createPanel2(); // 申请看房
        JPanel panel3 = createPanel3(); // 申请卖房
        JPanel panel4 = createPanel4(); // 查询业务员信息
        JPanel panel5 = createPanel5(); // 关于
        JPanel panel6 = createPanel6(frame); // 退出登录
//        button = new JButton(); // 退出登录
        tabbedPane1.addTab("个人信息", panel);
        tabbedPane1.addTab("查询房源", panel1);
        tabbedPane1.addTab("申请看房", panel2);
        tabbedPane1.addTab("申请卖房", panel3);
        tabbedPane1.addTab("查询业务员信息", panel4);
        tabbedPane1.addTab("关于", panel5);
//        tabbedPane1.addTab("退出登录", button);
        tabbedPane1.addTab("退出登录", panel6);
        this.add(tabbedPane1);
//        awtEvent(); //创建监听
    }

//    private void awtEvent() {
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                WinCustomer.super.setVisible(false);
//            }
//        });
//    }

    private JPanel createPanel(JFrame frame) throws Exception {
        JPanel panel = new JPanel(false);
        panel.setLayout(null);
        panel.add(new TabbleCustomerGeRenXinXi(panel, ID, frame));
        return panel;
    }
    private JPanel createPanel1() {
        JPanel panel = new JPanel(false);
        panel.setLayout(null);

        return panel;
    }
    private Component createPanel2() {
        JPanel panel = new JPanel(false);
        panel.setLayout(null);
        panel.add(new TabbleShenQingKanFang(panel, ID));
        return panel;
    }
    private JPanel createPanel3() {
        JPanel panel = new JPanel(false);
        panel.setLayout(null);
        panel.add(new TabbleMaiFang(panel, ID));
        return panel;
    }
    private JPanel createPanel4() {
        JPanel panel = new JPanel(false);
        panel.setLayout(null);
        panel.add(new TabbleSelectSMan(panel));
        return panel;
    }
    private JPanel createPanel5() {
        JPanel panel = new JPanel(false);
        panel.setLayout(null);
        panel.add(new TabbleAbout(panel));
        return panel;
    }

    private JPanel createPanel6(JFrame frame) {
        JPanel panel = new JPanel(false);
        panel.setLayout(null);
        panel.add(new TabbleExit(panel, frame));
        return panel;
    }

//    private JComponent makeTextPanle(String text) {
//        JPanel panel=new JPanel(false);
//        JLabel filler=new JLabel(text);
//        filler.setFont(new Font("宋体", 1, 50));
//        filler.setHorizontalAlignment(JLabel.CENTER);
//        panel.setLayout(new GridLayout(1,1));
//        panel.add(filler);
//        return panel;
//    }

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("客户");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String str = "2";
        frame.add(new WinCustomer(str, frame), BorderLayout.CENTER);
        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        int jframeWidth = 800;
        int jframeHeight = 600;
        frame.setBounds((screenWidth/2)-(jframeWidth/2), (screenHeight/2)-(jframeHeight/2), jframeWidth, jframeHeight);
        frame.setVisible(true);
    }
}
