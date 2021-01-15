package fhy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class Center {
    public static void main(String[] str) throws SQLException {
        Center cen=new Center();
        cen.printWindows();
    }
    public void printWindows() throws SQLException {
        JFrame jf = new JFrame("用户登录");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(1920,1080);
        System.out.println("main.runn里面");
        SpringLayout spring =new SpringLayout();
        JPanel outBox= new JPanel(null);//用于装填合成的组件
        outBox.add(constructInPanel("全部","",1));
        /*使用constructInpanel（）方法就就可以直接构造出那个panel；
        前两个参数保持这样就好
        第三个参数
        1表示这个panel可以编辑（给管理员使用），
        0表示这个panel不能编辑（给用户界面使用）
        你可以改成0试试看
        */
        jf.setContentPane(outBox);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
    public JPanel constructInPanel(String attribute ,String val ,int creType) throws SQLException {
        //JPanel OutPanel=new JPanel(new FlowLayout());
        JPanel inPanel=new JPanel(null);
        JPanel OutPanel=creOutPanel(attribute,val,creType);//用于存放滚动面板的面板
        JPanel searchBarPanel=new JPanel(null);//用于存放搜索条的面板
        inPanel.setLocation(0,0);
        inPanel.setSize(1000,1000);
        searchBarPanel.setLocation(0,0);
        searchBarPanel.setSize(1000,52);
        ConstructSearchBar searchbar1=new ConstructSearchBar();

        JPanel contentScr=new JPanel();
        JButton bt1=new JButton("搜索");
        JButton bt2=new JButton("刷新");
        bt1.setLocation(160*2,0);
        bt1.setSize(160,26*2);
        bt2.setLocation(160*4-16*2,0);
        bt2.setSize(26*2,26*2);
        JTextField txtSearch=new JTextField("请输入要搜索的值");
        txtSearch.setLocation(160,0);
        txtSearch.setSize(160,26*2);
        bt1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inPanel.remove(OutPanel);
                JPanel newOutPanel= null;
                try {
                    newOutPanel = creOutPanel(ConstructSearchBar.attribute,txtSearch.getText(),creType);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                inPanel.add(newOutPanel);
                inPanel.validate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        bt2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inPanel.remove(OutPanel);
                JPanel newOutPanel= null;
                try {
                    newOutPanel = creOutPanel(ConstructSearchBar.attribute,txtSearch.getText(),creType);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                inPanel.add(newOutPanel);
                inPanel.validate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        JTextField txt1=new JTextField();
        txt1.setLocation(0,0);
        txt1.setSize(200,20000);


        //AllContentPane cp=new AllContentPane(10,1);

        searchBarPanel.add(searchbar1.getSearchBar());
        //OutPanel.add(inScrollPanel);
        inPanel.add(txtSearch);
        inPanel.add(bt1);
        inPanel.add(bt2);
        inPanel.add(searchBarPanel);
        inPanel.add(OutPanel);
        return inPanel;
    }

    public JPanel creOutPanel(String attribute ,String val ,int creType) throws SQLException {
        JPanel OutPanel=new JPanel(new GridLayout(1,1));
        OutPanel.setLocation(0,52);
        OutPanel.setSize(1000,1000);
        JPanel inScr=new JPanel(null);//滚动面板中的内嵌面板
        JScrollPane inScrollPanel =new JScrollPane(inScr, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        OutPanel.add(inScrollPanel);
        inScr.setSize(19200,1080);
        inScr.setPreferredSize(new Dimension(20000,60*50));
        inScr.setLocation(0,0);
        AllContentPane al=new AllContentPane(10,attribute,val,creType);
        inScr.add(al.getOut());
        return OutPanel;
    }
}
