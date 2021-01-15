package fhy;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ConstructSearchBar {
    static String attribute="全部";
    int contentPaneWidth=800;
    int perContentWidth=(int)contentPaneWidth/5;
    int contentPaneHeight=130;
    int perContentHeight=(int)contentPaneHeight/5;
    JPanel  searchBar;
    public JPanel getSearchBar(){
        return searchBar;
    }
    ConstructSearchBar(){
        searchBar =new JPanel(null);
        searchBar.setSize(contentPaneWidth,perContentHeight*2);
        String[] listData = new String[]{"全部","售价","室内面积","房型","房源名称","楼层","朝向","装修","楼型","供暖方式","采光","建筑年代","税费","小区","电梯","产权性质","适宜人群","省","市","区","街道","具体"};
        // 创建一个下拉列表框
        final JComboBox<String> comboBox = new JComboBox<String>(listData);
        comboBox.setLocation(0,0);
        comboBox.setSize(perContentWidth,perContentHeight*2);
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    attribute=comboBox.getSelectedItem().toString();
                    System.out.println(attribute);
                    System.out.println("选中: " + comboBox.getSelectedIndex() + " = " + comboBox.getSelectedItem());
                }
            }
        });
        JTextField txtSearch=new JTextField("请输入要搜索的值");
        JButton bt1=new JButton("搜索");
        bt1.setLocation(perContentWidth*2,0);
        bt1.setSize(perContentWidth,perContentHeight*2);
        txtSearch.setLocation(perContentWidth,0);
        txtSearch.setSize(perContentWidth,perContentHeight*2);
        //searchBar.add(bt1);
        //searchBar.add(txtSearch);
        searchBar.add(comboBox);
        bt1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SearchHouse se=new SearchHouse();
                se.findHouseUnLimit(attribute,txtSearch.getText());
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
}
