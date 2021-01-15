package fhy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Optional;

public class Main {
    static int isflash=1;//0表示数据没有更新
    static int page=1;
    static int[] expand_unexpand=new int[10];
    //JFrame jf;//控制在页面中哪些选项是展开的或者折叠的0为折叠，1为展开更换页面时该数值更新为全0;
    public static void printExpand_Unexpand(){
        for(int i=0;i<10;i++){
            System.out.print(expand_unexpand[i]+",");
        }
        System.out.println(" ");
    }
    public static void flashExpand_Unexpand(){
        for(int i=0;i<10;i++){
            expand_unexpand[i]=1;
        }
    }

    public void run() {
        //System.out.println("MAIN.runn");
            //System.out.println("for的位置");
            //System.out.println("MAIN.GUICANPRINT:"+GUI.canPrint);
            //while(true){
                if(GUI.canPrint==1){
                    JFrame jf = new JFrame("用户登录");
                    jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    jf.setSize(1920,1080);
                    System.out.println("main.runn里面");
                    SpringLayout spring =new SpringLayout();
                    JPanel outBox= new JPanel(null);//用于装填合成的组件

                    //JPanel OutPanel=new JPanel(new FlowLayout());
                    JPanel OutPanel=new JPanel(new GridLayout(1,1));//用于存放滚动面板的面板
                    JPanel searchBarPanel=new JPanel(null);
                    searchBarPanel.setLocation(0,0);
                    searchBarPanel.setSize(1000,52);
                    ConstructSearchBar searchbar1=new ConstructSearchBar();
                    OutPanel.setLocation(0,52);

                    OutPanel.setSize(1000,1000);
                    JPanel inScr=new JPanel(null);//滚动面板中的内嵌面板
                    JPanel contentScr=new JPanel();
                    Button bt1=new Button();
                    JTextField txt1=new JTextField();
                    txt1.setLocation(0,0);
                    txt1.setSize(200,20000);
                    //bt1.setLocation(0,0);
                    //bt1.setSize(5000,10000);
                    //inScr.add(bt1);
                    //inScr.add(txt1);
                    inScr.setSize(19200,1080);
                    inScr.setPreferredSize(new Dimension(20000,60*50));
                    inScr.setLocation(0,0);
                    JScrollPane inScrollPanel =new JScrollPane(inScr, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    //AllContentPane cp=new AllContentPane(10,1);
                    //cp.runn();
                    //System.out.println("要add了");
                    JPanel getPrint=GUI.exchangPanle;
                    inScr.add(getPrint);
                    GUI.canPrint=0;
                    searchBarPanel.add(searchbar1.getSearchBar());
                    OutPanel.add(inScrollPanel);
                    outBox.add(searchBarPanel);
                    outBox.add(OutPanel);
                    jf.setContentPane(outBox);
                    jf.setLocationRelativeTo(null);
                    jf.setVisible(true);
                }
                //System.out.println("main末尾");
            //}

    }
    Main(){

    }

    public static void main(String[] args) throws SQLException, InterruptedException {

    }

    public static int cal_Y_Point(int line){
        int ComponentHeight=130;
        return line*ComponentHeight;
    }

}