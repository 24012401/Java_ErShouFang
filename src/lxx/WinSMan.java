package lxx;

import javax.swing.*;
import java.awt.*;

/**
 * author: 刘晓霞
 * function: 利用选项卡组件实现类似网页的业务员功能界面
 * time: 2021/1/12
 */

public class WinSMan extends JPanel {
    String ID;

    public WinSMan(String id, JFrame frame) throws Exception {
        super(new GridLayout(1, 1));
        ID = id;
        JTabbedPane tabbedPane1 = new JTabbedPane();

        JPanel panel = createPanel(frame); // 查看个人信息
        JPanel panel1 = createPanel1(); // 查询房源
        Component panel2 = createPanel2(); // 查询客户信息
        JPanel panel3 = createPanel3(); // 录入合同
        JPanel panel4 = createPanel4(); // 新建看房时间通知
        JPanel panel5 = createPanel5(); // 关于
        JPanel panel6 = createPanel6(frame); // 退出登录

        tabbedPane1.addTab("个人信息", panel);
        tabbedPane1.addTab("查询房源", panel1);
        tabbedPane1.addTab("查询客户", panel2);
        tabbedPane1.addTab("录入合同", panel3);
        tabbedPane1.addTab("新建通知", panel4);
        tabbedPane1.addTab("关于", panel5);
        tabbedPane1.addTab("退出登录", panel6);
        this.add(tabbedPane1);
    }

    private JPanel createPanel(JFrame frame) throws Exception{
        JPanel panel = new JPanel(false);
        panel.setLayout(null);
        panel.add(new TabbleSManGeRenXinXi(panel, ID, frame));
        return panel;
    }
    private JPanel createPanel1() {
        JPanel panel = new JPanel(false);
        panel.setLayout(null);
        panel.add(new TabbleSelectHouse(panel));
        return panel;
    }
    private Component createPanel2() throws Exception {
        JPanel panel = new JPanel(false);
        panel.setLayout(null);
        panel.add(new TabbleSelectCustomer(panel));
        return panel;
    }
    private JPanel createPanel3() {
        JPanel panel = new JPanel(false);
        panel.setLayout(null);
        panel.add(new TabbleAddContracts(panel));
        return panel;
    }
    private JPanel createPanel4() {
        JPanel panel = new JPanel(false);
        panel.setLayout(null);
        panel.add(new TabbleAddNotices(panel));
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

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("业务员");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String str = "3";
        frame.add(new WinSMan(str, frame), BorderLayout.CENTER);
        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        int jframeWidth = 800;
        int jframeHeight = 600;
        frame.setBounds((screenWidth/2)-(jframeWidth/2), (screenHeight/2)-(jframeHeight/2), jframeWidth, jframeHeight);
        frame.setVisible(true);
    }
}
