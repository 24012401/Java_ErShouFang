package fhy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class GUI {
    public static int isFlash=1;
    private static JPanel getPrint;
    int count=1;
    public static JTextField txtSearch=new JTextField();
    public static JPanel outBox=new JPanel(null);
    public static int canPrint=0;//1表示可以绘制
    public static JPanel exchangPanle;
    int contentPaneWidth=800;
    int perContentWidth=(int)contentPaneWidth/5;
    int contentPaneHeight=130;
    int perContentHeight=(int)contentPaneHeight/5;
    int expandPanelHeight=perContentHeight*9;
    public static JFrame jf=new JFrame("jf1");
    static class btListen implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("mouse");
            SearchHouse se=new SearchHouse();
            GuiHouseData searchdate1= null;
            try {
                searchdate1 = new  GuiHouseData(se.findHouseUnLimit(ConstructSearchBar.attribute,txtSearch.getText()));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            AllContentPane al2= null;
            try {
                al2 = new AllContentPane(10,"","",1);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            al2.run(searchdate1);
            //JFrame jf2 = new JFrame("用户登录");
            //jf2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //jf2.setSize(1920,1080);
            System.out.println("main.runn里面");
            JPanel outBox2= new JPanel(null);//用于装填合成的组件

            JPanel OutPanel=new JPanel(new GridLayout(1,1));//用于存放滚动面板的面板
            JPanel searchBarPanel=new JPanel(null);
            searchBarPanel.setLocation(0,0);
            searchBarPanel.setSize(1000,52);
            ConstructSearchBar searchbar1=new ConstructSearchBar();
            OutPanel.setLocation(0,52);
            OutPanel.setSize(1000,1000);
            JPanel iinScr=new JPanel(null);//滚动面板中的内嵌面板
            JPanel contentScr=new JPanel();
            //Button bt2=new Button();
            JTextField txt1=new JTextField();
            txt1.setLocation(0,0);
            txt1.setSize(200,20000);
            //bt1.setLocation(0,0);
            //bt1.setSize(5000,10000);
            //inScr.add(bt1);
            //inScr.add(txt1);
            iinScr.setSize(19200,1080);
            iinScr.setPreferredSize(new Dimension(20000,60*50));
            iinScr.setLocation(0,0);
            JScrollPane inScrollPanel2 =new JScrollPane(iinScr, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            //AllContentPane cp=new AllContentPane(10,1);
            //cp.runn();
            //System.out.println("要add了");
            //JPanel getPrint=al2.getOut();
            iinScr.add(al2.getOut());
            GUI.canPrint=0;
            searchBarPanel.add(searchbar1.getSearchBar());
            JButton bt2=new JButton("搜索");
            bt2.setLocation(160*2,0);
            bt2.setSize(160,26*2);
            JTextField txtSearch=new JTextField("请输入要搜索的值");
            txtSearch.setLocation(160,0);
            txtSearch.setSize(160,26*2);
            OutPanel.add(inScrollPanel2);
            bt2.addMouseListener(new btListen());
            outBox.removeAll();
            jf.removeAll();
            //outBox=new JPanel(null);
            JFrame jf2=new JFrame("jf2");
            outBox.add(searchBarPanel);
            outBox.add(OutPanel);
            outBox.add(txtSearch);
            outBox.add(bt2);
            //jf2.add(outBox);
            jf2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jf2.setSize(1920,1080);
            jf2.setContentPane(outBox);
            //jf.setContentPane(outBox);
            jf2.setLocationRelativeTo(null);
            jf2.setVisible(true);
            //jf.setContentPane(outBox);
            JPanel paneljhfoasifj=new JPanel();
            JLabel labeljfksdfj=new JLabel("lable");
            paneljhfoasifj.add(labeljfksdfj);
            //jf.add(paneljhfoasifj);
            //jf2.setLocationRelativeTo(null);
            jf.validate();
            //jf.dispose();
            jf.setVisible(true);
            System.out.println("处理结束");
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
    }
    /*public synchronized void put(JPanel inPanel){
        while (count == 0){ //buffer已经满了 等待get   ,用while使用于多个生产者的情况
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        notifyAll(); //说明buffer中有元素 可以取
        buffer[count++] = value;
        System.out.println("Put "+value+" current size = "+count);
    }

    public synchronized int get(){
        while(count == 0){//用while使用于多个消费者的情况。
            try {
                wait();//buffer为空，需要等到put进元素
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }*/
    public static void main(String[] args) throws SQLException {
        System.out.println("GUI main");

        GUI gui=new GUI();
        Main mai=new Main();
        AllContentPane al=new AllContentPane(10,"","",1);
        SearchHouse sh=new SearchHouse();
        GuiHouseData hd=new GuiHouseData(sh.findHouseLimit(Main.page));
        al.run(hd);

        //mai.run();
        //new Thread(al,"all").start();new Thread(mai,"mi").start();
        //JFrame jf = new JFrame("用户登录");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(1920,1080);
        System.out.println("main.runn里面");
        SpringLayout spring =new SpringLayout();
        JPanel outBox= new JPanel(null);//用于装填合成的组件
        JPanel OutPanel=new JPanel(new GridLayout(1,1));//用于存放滚动面板的面板
        JPanel searchBarPanel=new JPanel(null);
        searchBarPanel.setLocation(0,0);
        searchBarPanel.setSize(1000,52);
        ConstructSearchBar searchbar1=new ConstructSearchBar();
        OutPanel.setLocation(0,52);
        OutPanel.setSize(1000,1000);
        JPanel inScr=new JPanel(null);//滚动面板中的内嵌面板
        JPanel contentScr=new JPanel();
        JButton bt1=new JButton("搜索");
        bt1.setLocation(160*2,0);
        bt1.setSize(160,26*2);
        txtSearch.setLocation(160,0);
        txtSearch.setSize(160,26*2);
        bt1.addMouseListener(new btListen());
        JTextField txt1=new JTextField();
        txt1.setLocation(0,0);
        txt1.setSize(200,20000);
        inScr.setSize(19200,1080);
        inScr.setPreferredSize(new Dimension(20000,60*50));
        inScr.setLocation(0,0);
        JScrollPane inScrollPanel =new JScrollPane(inScr, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        inScr.add(al.getOut());
        searchBarPanel.add(searchbar1.getSearchBar());
        OutPanel.add(inScrollPanel);
        outBox.add(txtSearch);
        outBox.add(bt1);
        outBox.add(searchBarPanel);
        outBox.add(OutPanel);
        jf.setContentPane(outBox);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
