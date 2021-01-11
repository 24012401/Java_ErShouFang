package lxx;

import javafx.embed.swt.SWTFXUtils;

import javax.swing.*;
import java.awt.*;

public class WinCustomer extends JPanel {

    public WinCustomer() {
        super(new GridLayout(1, 1));
        JTabbedPane tabbedPane1 = new JTabbedPane();
        JPanel panel = new JPanel(); // 查看个人信息
        JPanel panel1 = new JPanel(); // 查询房源
        JPanel panel2 = new JPanel(); // 申请看房
        JPanel panel3 = new JPanel(); // 申请卖房
        JPanel panel4 = new JPanel(); // 查询业务员信息
        JPanel panel5 = new JPanel(); // 关于
        JPanel panel6 = new JPanel(); // 退出登录
        tabbedPane1.addTab("个人信息", panel);
        tabbedPane1.addTab("查询房源", panel1);
        tabbedPane1.addTab("申请看房", panel2);
        tabbedPane1.addTab("申请卖房", panel3);
        tabbedPane1.addTab("查询业务员信息", panel4);
        tabbedPane1.addTab("关于", panel5);
        tabbedPane1.addTab("退出登录", panel6);
        this.add(tabbedPane1);
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("客户");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new WinCustomer(), BorderLayout.CENTER);
        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        int jframeWidth = 800;
        int jframeHeight = 600;
        frame.setBounds((screenWidth/2)-(jframeWidth/2), (screenHeight/2)-(jframeHeight/2), jframeWidth, jframeHeight);
        frame.setVisible(true);
    }
}
