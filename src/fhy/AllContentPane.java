package fhy;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class AllContentPane {
    ArrayList<ContentPanel> contentPanels;
    int creType;
    int printHouseNumber;
    int number;
    JPanel out;
    public JPanel getOut(){
        return out;
    }
    AllContentPane(int num,String attribute,String val,int type) throws SQLException {
        creType=type;
        number=num;
        if(attribute=="全部"){
            SearchHouse sh=new SearchHouse();
            GuiHouseData hd=new GuiHouseData(sh.findHouseLimit(Main.page));
            run(hd);
        }else{
            SearchHouse se=new SearchHouse();
            GuiHouseData searchdate1 = new  GuiHouseData(se.findHouseUnLimit(attribute,val));
            run(searchdate1);
        }

    }
    public void run(GuiHouseData ghd){
        System.out.println("while外面");
            System.out.println("ALL.isflash"+GUI.isFlash);
                    try {
                        JPanel ininScr=new JPanel(null);//内嵌面板中的内嵌面板
                        ininScr.setSize(19200,20000);
                        ininScr.setLocation(0,0);
                        creContentPanel(ghd);
                        for(int j=0;j<printHouseNumber;j++){
                            ininScr.add(getpanel(j));
                            System.out.println("addpanel:"+j);
                        }
                        System.out.println("while 里面");
                        GUI.isFlash=0;
                        //GUI.exchangPanle=ininScr;
                        out=ininScr;
                        GUI.canPrint=1;
                        System.out.println("GUIcanprint="+GUI.canPrint);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
    }
    public void creContentPanel(GuiHouseData ghd)  throws SQLException {
        contentPanels=new ArrayList<ContentPanel>();


        System.out.println(ghd.housesNumber()+"housenum");
        printHouseNumber= ghd.housesNumber();
        //Main.flashExpand_Unexpand();
        for(int i=0;i<number;i++){
            ContentPanel contentPanel=new ContentPanel(0,i,Main.expand_unexpand[i]);
            contentPanel.ou=i;
            if(i< ghd.housesNumber()){
                contentPanel.crepanel(ghd.returnHouse(i));
                if(Main.expand_unexpand[i]==1){
                    contentPanel.crepanel2(ghd.returnHouse(i));
                }
                contentPanel.putPanels(contentPanels,creType);
                contentPanels.add(contentPanel);
            }else{
            }
        }
    }
    public JPanel getpanel(int i){
        return contentPanels.get(i).getContent();
    }
}
