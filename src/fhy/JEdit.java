package fhy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JEdit{
    int model=0;//0为显示状态，1为编辑状态
    JTextField txtVal;
    JLabel labelVal;
    String attribute1;
    String val1;
    int houseId1;
    JPanel editPanel;
    int contentPaneWidth=800;
    int perContentWidth=(int)contentPaneWidth/5;
    int contentPaneHeight=130;
    int perContentHeight=(int)contentPaneHeight/5;
    int expandPanelHeight=perContentHeight*9;
    public void switchModel(){
        if(model==0){
            model=1;
        }else {
            model=0;
        }
    }
    JEdit(String attribute,String val,int type,int houseId){
        if(type==1){
            val1=val;
            attribute1=attribute;
            houseId1=houseId;
            editPanel=new JPanel(null);
            editPanel.setLocation(0,0);
            editPanel.setSize(contentPaneWidth*2,contentPaneHeight);
            txtVal=new JTextField(val1);
            txtVal.setLocation(100,0);
            txtVal.setSize(150,perContentHeight);
            JLabel labelAttribute=new JLabel(attribute);
            labelVal=new JLabel(val);
            labelAttribute.setFont(new Font("黑体",Font.BOLD,20));
            labelAttribute.setForeground(Color.gray);
            labelVal.setFont(new Font("黑体",Font.BOLD,20));
            labelVal.setForeground(Color.BLACK);
            labelAttribute.setLocation(0,0);
            labelAttribute.setSize(100,perContentHeight);
            labelVal.setLocation(100,0);
            labelVal.setSize(150,perContentHeight);
            JButton bt1=new JButton();
            bt1.setLocation(250,0);
            bt1.setSize(perContentHeight,perContentHeight);
            bt1.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    btClick();
                    editPanel.validate();
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
            editPanel.add(labelAttribute);
            editPanel.add(labelVal);
            editPanel.add(bt1);
        }else {
            editPanel=new JPanel(null);
            editPanel.setLocation(0,0);
            editPanel.setSize(contentPaneWidth*2,contentPaneHeight);
            JLabel labelAttribute=new JLabel(attribute);
            JLabel labelVal=new JLabel(val);
            labelAttribute.setFont(new Font("黑体",Font.BOLD,20));
            labelAttribute.setForeground(Color.gray);
            labelVal.setFont(new Font("黑体",Font.BOLD,20));
            labelVal.setForeground(Color.BLACK);
            labelAttribute.setLocation(0,0);
            labelAttribute.setSize(100,perContentHeight);
            labelVal.setLocation(100,0);
            labelVal.setSize(150,perContentHeight);
            //JButton bt1=new JButton();
            //bt1.setLocation(250,0);
            //bt1.setSize(perContentHeight,perContentHeight);
            editPanel.add(labelAttribute);
            editPanel.add(labelVal);
            //editPanel.add(bt1);
        }
    }
    public void btClick(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(model==0){//转为编辑状态
                    switchModel();
                    editPanel.remove(labelVal);
                    editPanel.validate();
                    editPanel.add(txtVal);
                    editPanel.validate();
                }else {
                    switchModel();
                    val1=txtVal.getText();
                    SearchHouse se=new SearchHouse();
                    se.settingDate(attribute1,val1,houseId1);
                    GUI.isFlash=1;
                    System.out.println(txtVal.getText());
                    editPanel.remove(txtVal);
                    editPanel.validate();
                    labelVal.setText(val1);
                    editPanel.add(labelVal);
                    editPanel.validate();
                }
            }
        }).start();

    }
    public JPanel getEditPanel(){
        return editPanel;
    }
}
