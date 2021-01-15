package fhy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContentPanel {
    private JPanel content;
    int creType;//是管理员还是普通用户
    int ou;//该变量表示该contentPanel对应expand_unexpand数组第几个元素
    int printHouseNumber;
    House littleHouse;
    JPanel PExpand;//拓展元素存放位置
    ArrayList<ContentPanel> contentPanels;
    int contentPaneWidth=800;
    int perContentWidth=(int)contentPaneWidth/5;
    int contentPaneHeight=130;
    int perContentHeight=(int)contentPaneHeight/5;
    int expandPanelHeight=perContentHeight*9;
    private int contentPanleType=0;//0为折叠，1为展开
    private int isAdmin=0;//0为不是管理源，1不是管理员
    public void switchAdmin(){
        if(isAdmin==0){
            isAdmin=1;
        }else {
            isAdmin=0;
        }
    }


    public int getExpandNumebr(int fron){//从第一个元素开始检索有几个expand的
        int number=0;
        for(int i=0;i<fron;i++) {
            System.out.println("inroll:"+i);
            if (contentPanels.get(i).getContentPanleType() == 1) {
                number++;
                System.out.println(number+":number"+contentPanels.get(i).getContentPanleType());
            }
        }
        return number;
    }

    public void setLittleHouse(House inHouse){
        littleHouse=inHouse;
    }

    public void putPanels(ArrayList<ContentPanel> cArray, int type){
        creType=type;
        contentPanels=cArray;
    }
    ContentPanel(){

    }
    ContentPanel(int expand,int unexpand,int isThisExpand){//isThisExpand如果为1那么则是展开的
        content=new JPanel(null);
        setContentLocate(expand,unexpand);
        //content.setLocation(0,cal_Y_Point(expand,unexpand));
        content.setSize(contentPaneWidth,contentPaneHeight);
        if(isThisExpand==1){
            switchType();
        }
    }

    ContentPanel(ResultSet res){
        content=new JPanel(null);
        //接下来写处理函数该函数传入的不是resultset而是House类
    }
    public void setContentLocate(int expand,int unexpand){
        content.setLocation(0,cal_Y_Point(expand,unexpand));
        System.out.println(cal_Y_Point(expand,unexpand));
        System.out.println(expand+":setContentLocate");
        System.out.println(unexpand);
    }
    public void setAllLocation(){
        for(int i=0;i<contentPanels.size();i++){
            System.out.println("rool"+i);
            //System.out.println("size:"+contentPanels.size());
            contentPanels.get(i).setContentLocate(getExpandNumebr(i),i-getExpandNumebr(i));
            System.out.println("expand"+getExpandNumebr(i+1));
            System.out.println("unexpand"+(i-getExpandNumebr(i+1)));
        }
    }

    public JPanel getContent() {
        return content;
    }

    public void crepanel(House hou){
        JPanel ccontent=new JPanel(null);
        ccontent.setSize(contentPaneWidth,contentPaneHeight);
        ccontent.setLocation(0,0);
        JPanel panelName=new JPanel(new GridLayout(1,1));
        JPanel panelType=new JPanel(new GridLayout(1,1));
        JPanel panelArea=new JPanel(new GridLayout(1,1));
        JPanel panelOritation=new JPanel(new GridLayout(1,1));
        JPanel panelFloor=new JPanel(new GridLayout(1,1));
        JPanel panelAddress=new JPanel(new GridLayout(1,1));
        JPanel panelOwner=new JPanel(new GridLayout(1,1));
        JPanel panelPrice=new JPanel(new GridLayout(1,1));
        panelName.setSize(perContentWidth*4,perContentHeight*2);
        panelType.setSize(perContentWidth,perContentHeight);
        panelArea.setSize(perContentWidth,perContentHeight);
        panelOritation.setSize(perContentWidth,perContentHeight);
        panelFloor.setSize(perContentWidth,perContentHeight);
        panelAddress.setSize(perContentWidth*4,perContentHeight);
        panelOwner.setSize(perContentWidth*4,perContentHeight);
        panelPrice.setSize(perContentWidth,perContentHeight*5);
        panelName.setLocation(0,0);
        panelType.setLocation(0,perContentHeight*2);
        panelArea.setLocation(perContentWidth,perContentHeight*2);
        panelOritation.setLocation(perContentWidth*2,perContentHeight*2);
        panelFloor.setLocation(perContentWidth*3,perContentHeight*2);
        panelAddress.setLocation(0,perContentHeight*3);
        panelOwner.setLocation(0,perContentHeight*4);
        panelPrice.setLocation(perContentWidth*4,0);
        JLabel labelName=new JLabel(hou.getHouseName());
        labelName.setFont(new Font("黑体",Font.BOLD,35));
        JLabel labelType=new JLabel(hou.getHouseType());
        labelType.setFont(new Font("黑体",Font.BOLD,20));
        labelType.setForeground(Color.gray);
        JLabel labelArea=new JLabel(String.valueOf(hou.getCarpetArea())+" m^2");
        labelArea.setFont(new Font("黑体",Font.BOLD,20));
        labelArea.setForeground(Color.gray);
        JLabel labelOrutation=new JLabel(hou.getOrientation());
        labelOrutation.setFont(new Font("黑体",Font.BOLD,20));
        labelOrutation.setForeground(Color.gray);
        JLabel labelFloor=new JLabel(hou.getFloor()+"层");
        labelFloor.setFont(new Font("黑体",Font.BOLD,20));
        labelFloor.setForeground(Color.gray);
        JLabel labelAddress=new JLabel(hou.getNeighbourhood()+"-"+hou.getTown()+"-"+hou.getStreet());
        labelAddress.setFont(new Font("黑体",Font.BOLD,20));
        labelAddress.setForeground(Color.gray);
        JLabel labelOwner=new JLabel("Owner");
        labelOwner.setFont(new Font("黑体",Font.BOLD,20));
        labelOwner.setForeground(Color.gray);
        JLabel labelPrice=new JLabel(String.valueOf(hou.getPrice())+"元");
        labelPrice.setFont(new Font("黑体",Font.BOLD,35));
        labelPrice.setForeground(Color.red);
        panelName.add(labelName);
        panelType.add(labelType);
        panelArea.add(labelArea);
        panelOritation.add(labelOrutation);
        panelFloor.add(labelFloor);
        panelOwner.add(labelOwner);
        panelPrice.add(labelPrice);
        panelAddress.add(labelAddress);
        //panel01.add(new JLabel("用户名"));
        JTextField txt=new JTextField(100);
        ccontent.add(panelName);
        ccontent.add(panelType);
        ccontent.add(panelArea);
        ccontent.add(panelOritation);
        ccontent.add(panelFloor);
        ccontent.add(panelAddress);
        ccontent.add(panelOwner);
        ccontent.add(panelPrice);
        content.add(ccontent);
        ccontent.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                switchType();
                crepanel2(hou);
                content.repaint();

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
    }
    public void crepanel2(House hou){
        new Thread(new Runnable() {
            @Override
            public void run() {
                PExpand = new JPanel(null);PExpand.setSize(contentPaneWidth, expandPanelHeight);PExpand.setLocation(0, contentPaneHeight);System.out.println("这是"+hou.getFloor());JEdit edit1=new JEdit("售价",String.valueOf(hou.getPrice()),creType,hou.getHouseId());JEdit edit2=new JEdit("室内面积",String.valueOf(hou.getCarpetArea()),creType,hou.getHouseId());
                JEdit edit3=new JEdit("房型",hou.getHouseType(),creType,hou.getHouseId());
                JEdit edit4=new JEdit("楼层",hou.getFloor(),creType,hou.getHouseId());
                JEdit edit5=new JEdit("朝向",hou.getOrientation(),creType,hou.getHouseId());
                JEdit edit6=new JEdit("装修",hou.getRenovation(),creType,hou.getHouseId());
                JEdit edit7=new JEdit("楼型",hou.getBuildingType(),creType,hou.getHouseId());
                JEdit edit8=new JEdit("供暖方式",hou.getHeatingMode(),creType,hou.getHouseId());
                JEdit edit9=new JEdit("采光",hou.getLighting(),creType,hou.getHouseId());
                JEdit edit10=new JEdit("建筑年代",hou.getYear(),creType,hou.getHouseId());
                JEdit edit11=new JEdit("电梯",hou.getElevator(),creType,hou.getHouseId());
                JEdit edit12=new JEdit("产权性质",hou.getProperty(),creType,hou.getHouseId());
                JEdit edit13=new JEdit("核心卖点",hou.getSellingPoint(),creType,hou.getHouseId());
                JEdit edit14=new JEdit("适宜人群",hou.getSuitablePopulation(),creType,hou.getHouseId());
                JEdit edit15=new JEdit("地址",hou.getProvince()+hou.getCity()+hou.getTown()+hou.getStreet(),creType,hou.getHouseId());
                JEdit edit16=new JEdit("业主心态",hou.getMentality(),creType,hou.getHouseId());
                JPanel panel1 = new JPanel(null);
                JPanel panel2 = new JPanel(new GridLayout(1, 2));
                JPanel panel3 = new JPanel(new GridLayout(1, 2));
                JPanel panel4 = new JPanel(new GridLayout(1, 2));
                JPanel panel5 = new JPanel(new GridLayout(1, 2));
                JPanel panel6 = new JPanel(new GridLayout(1, 2));
                JPanel panel7 = new JPanel(new GridLayout(1, 2));
                JPanel panel8 = new JPanel(new GridLayout(1, 2));
                JPanel panel9 = new JPanel(new GridLayout(1, 2));
                JPanel panel10 = new JPanel(new GridLayout(1, 2));
                JPanel panel11 = new JPanel(new GridLayout(1, 2));
                JPanel panel12 = new JPanel(new GridLayout(1, 2));
                JPanel panel13 = new JPanel(new GridLayout(1, 2));
                JPanel panel14 = new JPanel(new GridLayout(1, 2));
                JPanel panel15 = new JPanel(new GridLayout(1, 2));
                JPanel panel16 = new JPanel(new GridLayout(1, 2));
                panel1.setSize(perContentWidth * 2, perContentHeight);
                panel2.setSize(perContentWidth * 2, perContentHeight);
                panel3.setSize(perContentWidth * 2, perContentHeight);
                panel4.setSize(perContentWidth * 2, perContentHeight);
                panel5.setSize(perContentWidth * 2, perContentHeight);
                panel6.setSize(perContentWidth * 2, perContentHeight);
                panel7.setSize(perContentWidth * 2, perContentHeight);
                panel8.setSize(perContentWidth * 2, perContentHeight);
                panel9.setSize(perContentWidth * 2, perContentHeight);
                panel10.setSize(perContentWidth * 2, perContentHeight);
                panel11.setSize(perContentWidth * 2, perContentHeight);
                panel12.setSize(perContentWidth * 2, perContentHeight);
                panel13.setSize(perContentWidth * 2, perContentHeight);
                panel14.setSize(perContentWidth * 2, perContentHeight);
                panel15.setSize(perContentWidth * 4, perContentHeight);
                panel16.setSize(perContentWidth * 4, perContentHeight);
                panel1.setLocation(perContentWidth * 0, perContentHeight * 0);
                panel2.setLocation(perContentWidth * 2, perContentHeight * 0);
                panel3.setLocation(perContentWidth * 0, perContentHeight * 1);
                panel4.setLocation(perContentWidth * 2, perContentHeight * 1);
                panel5.setLocation(perContentWidth * 0, perContentHeight * 2);
                panel6.setLocation(perContentWidth * 2, perContentHeight * 2);
                panel7.setLocation(perContentWidth * 0, perContentHeight * 3);
                panel8.setLocation(perContentWidth * 2, perContentHeight * 3);
                panel9.setLocation(perContentWidth * 0, perContentHeight * 4);
                panel10.setLocation(perContentWidth * 2, perContentHeight * 4);
                panel11.setLocation(perContentWidth * 0, perContentHeight * 5);
                panel12.setLocation(perContentWidth * 2, perContentHeight * 5);
                panel13.setLocation(perContentWidth * 0, perContentHeight * 6);
                panel14.setLocation(perContentWidth * 2, perContentHeight * 6);
                panel15.setLocation(perContentWidth * 0, perContentHeight * 7);
                panel16.setLocation(perContentWidth * 0, perContentHeight * 8);
                    /*JLabel label11 = new JLabel("bala");
                    JLabel label21 = new JLabel("bala");
                    JLabel label12 = new JLabel("bala");
                    JLabel label22 = new JLabel("bala");
                    JLabel label13 = new JLabel("bala");
                    JLabel label23 = new JLabel("bala");
                    JLabel label14 = new JLabel("bala");
                    JLabel label24 = new JLabel("bala");
                    JLabel label15 = new JLabel("bala");
                    JLabel label25 = new JLabel("bala");
                    JLabel label16 = new JLabel("bala");
                    JLabel label26 = new JLabel("bala");
                    JLabel label17 = new JLabel("bala");
                    JLabel label27 = new JLabel("bala");
                    JLabel label18 = new JLabel("bala");
                    JLabel label28 = new JLabel("bala");
                    JLabel label19 = new JLabel("bala");
                    JLabel label29 = new JLabel("bala");
                    JLabel label110 = new JLabel("bala");
                    JLabel label210 = new JLabel("bala");
                    JLabel label111 = new JLabel("bala");
                    JLabel label211 = new JLabel("bala");
                    JLabel label112 = new JLabel("bala");
                    JLabel label212 = new JLabel("bala");
                    JLabel label113 = new JLabel("bala");
                    JLabel label213 = new JLabel("bala");
                    JLabel label114 = new JLabel("bala");
                    JLabel label214 = new JLabel("bala");
                    JLabel label115 = new JLabel("bala");
                    JLabel label215 = new JLabel("bala");
                    JLabel label116 = new JLabel("bala");
                    JLabel label216 = new JLabel("bala00000");*/
                    panel1.add(edit1.getEditPanel());
                    panel2.add(edit2.getEditPanel());
                panel3.add(edit3.getEditPanel());
                panel4.add(edit4.getEditPanel());
                panel5.add(edit5.getEditPanel());
                panel6.add(edit6.getEditPanel());
                panel7.add(edit7.getEditPanel());
                panel8.add(edit8.getEditPanel());
                panel9.add(edit9.getEditPanel());
                panel10.add(edit10.getEditPanel());
                panel11.add(edit11.getEditPanel());
                panel12.add(edit12.getEditPanel());
                panel13.add(edit13.getEditPanel());
                panel14.add(edit14.getEditPanel());
                panel15.add(edit15.getEditPanel());
                panel16.add(edit16.getEditPanel());


                //panel1.add(label21);
                 /*   panel2.add(label12);
                    panel2.add(label22);
                    panel3.add(label13);
                    panel3.add(label23);
                    panel4.add(label14);
                    panel4.add(label24);
                    panel5.add(label15);
                    panel5.add(label25);
                    panel6.add(label16);
                    panel6.add(label26);
                    panel7.add(label17);
                    panel7.add(label27);
                    panel8.add(label18);
                    panel8.add(label28);
                    panel9.add(label19);
                    panel9.add(label29);
                    panel10.add(label110);
                    panel10.add(label210);
                    panel11.add(label111);
                    panel11.add(label211);
                    panel12.add(label112);
                    panel12.add(label212);
                    panel13.add(label113);
                    panel13.add(label213);
                    panel14.add(label114);
                    panel14.add(label214);
                    panel15.add(label115);
                    panel15.add(label215);
                    panel16.add(label116);
                    panel16.add(label216);

                  */
                    PExpand.add(panel1);
                    PExpand.add(panel2);
                    PExpand.add(panel3);
                    PExpand.add(panel4);
                    PExpand.add(panel5);
                    PExpand.add(panel6);
                    PExpand.add(panel7);
                    PExpand.add(panel8);
                    PExpand.add(panel9);
                    PExpand.add(panel10);
                    PExpand.add(panel11);
                    PExpand.add(panel12);
                    PExpand.add(panel13);
                    PExpand.add(panel14);
                    PExpand.add(panel15);
                    PExpand.add(panel16);
                    content.add(PExpand);
                    setAllLocation();
                    content.validate();
                    PExpand.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            System.out.println("i,fell click");
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
            }
        }).start();

    }

    void switchType(){
        if(contentPanleType==0){
            contentPanleType=1;
            content.setSize(contentPaneWidth,contentPaneHeight+expandPanelHeight);
            Main.expand_unexpand[ou]=1;

        }else {
            contentPanleType=0;
            content.setSize(contentPaneWidth,contentPaneHeight);
            Main.expand_unexpand[ou]=0;
        }
        Main.printExpand_Unexpand();

    }
    public int getContentPanleType() {
        return contentPanleType;
    }
    public  int cal_Y_Point(int expand,int unexpand){
        int sit=unexpand*contentPaneHeight+expand*(expandPanelHeight+contentPaneHeight);
        return sit;
    }
}
