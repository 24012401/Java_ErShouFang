package syx.SaleApplication;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jan 11 00:03:47 CST 2021
 */



/**
 * @author Brainrain
 */
public class SaleApplication extends JFrame {
    //ActionListener listener=new SaleApplicationListen();
    MyCommandListener listener;
    public static void main(String[] args){
        SaleApplication sa = new SaleApplication();
        sa.setBounds(100,100,450,900);
        sa.setTitle("测试2");
    }

    public SaleApplication() {
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        panel1 = new JPanel();
        label12 = new JLabel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        center = new JPanel();
        panel6 = new JPanel();
        panel10 = new JPanel();
        panel8 = new JPanel();
        hname = new JLabel();
        htype = new JLabel();
        harea = new JLabel();
        hprice = new JLabel();
        hfloor = new JLabel();
        hdirectioin = new JLabel();
        hrenovition = new JLabel();
        buildingtype = new JLabel();
        heatingmote = new JLabel();
        lighting = new JLabel();
        buildingage = new JLabel();
        taxation = new JLabel();
        village = new JLabel();
        elevator = new JLabel();
        porperty_right = new JLabel();
        down_payment = new JLabel();
        selling_points = new JLabel();
        owner_mentality = new JLabel();
        suitable_population = new JLabel();
        provinces = new JLabel();
        cities = new JLabel();
        region = new JLabel();
        street = new JLabel();
        specific = new JLabel();
        panel9 = new JPanel();
        hname_in = new JTextField();
        htype_select = new JComboBox<>();
        harea_in = new JTextField();
        hprice_in = new JTextField();
        hfloor_in = new JTextField();
        hdirection_select = new JComboBox<>();
        hrenovition_select = new JComboBox<>();
        buildingtype_select = new JComboBox<>();
        heatingmote_select = new JComboBox<>();
        lighting_select = new JComboBox<>();
        buildingage_in = new JTextField();
        taxation_in = new JTextField();
        village_in = new JTextField();
        elevator_select = new JComboBox<>();
        property_right_select = new JComboBox<>();
        down_payment_in = new JTextField();
        selling_points_in = new JTextField();
        owner_mentality_in = new JTextField();
        suitable_population_in = new JTextField();
        provinces_in = new JTextField();
        cities_in = new JTextField();
        region_in = new JTextField();
        street_in = new JTextField();
        specific_in = new JTextField();
        panel11 = new JPanel();
        sure = new JButton();
        exit = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(600, 200));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(40, 40));

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout(10, 10));

            //---- label12 ----
            label12.setText(bundle.getString("SaleApplication.label12.text"));
            label12.setHorizontalAlignment(SwingConstants.CENTER);
            label12.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
            panel1.add(label12, BorderLayout.CENTER);
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setLayout(new BorderLayout());
        }
        contentPane.add(panel2, BorderLayout.WEST);

        //======== panel3 ========
        {
            panel3.setLayout(new BorderLayout());
        }
        contentPane.add(panel3, BorderLayout.EAST);

        //======== panel4 ========
        {
            panel4.setLayout(new BorderLayout());
        }
        contentPane.add(panel4, BorderLayout.SOUTH);

        //======== center ========
        {
            center.setLayout(new BorderLayout(0, 10));

            //======== panel6 ========
            {
                panel6.setLayout(new GridLayout(1, 2, 50, 10));

                //======== panel10 ========
                {
                    panel10.setLayout(new GridLayout());

                    //======== panel8 ========
                    {
                        panel8.setMaximumSize(new Dimension(30, 32767));
                        panel8.setMinimumSize(new Dimension(30, 30));
                        panel8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
                        panel8.setLayout(new GridLayout(24, 1, 0, 5));

                        //---- hname ----
                        hname.setText(bundle.getString("SaleApplication.hname.text"));
                        hname.setMaximumSize(new Dimension(30, 17));
                        hname.setIconTextGap(6);
                        panel8.add(hname);

                        //---- htype ----
                        htype.setText(bundle.getString("SaleApplication.htype.text"));
                        panel8.add(htype);

                        //---- harea ----
                        harea.setText(bundle.getString("SaleApplication.harea.text"));
                        panel8.add(harea);

                        //---- hprice ----
                        hprice.setText(bundle.getString("SaleApplication.hprice.text"));
                        panel8.add(hprice);

                        //---- hfloor ----
                        hfloor.setText(bundle.getString("SaleApplication.hfloor.text"));
                        panel8.add(hfloor);

                        //---- hdirectioin ----
                        hdirectioin.setText(bundle.getString("SaleApplication.hdirectioin.text"));
                        panel8.add(hdirectioin);

                        //---- hrenovition ----
                        hrenovition.setText(bundle.getString("SaleApplication.hrenovition.text"));
                        panel8.add(hrenovition);

                        //---- buildingtype ----
                        buildingtype.setText(bundle.getString("SaleApplication.buildingtype.text"));
                        panel8.add(buildingtype);

                        //---- heatingmote ----
                        heatingmote.setText(bundle.getString("SaleApplication.heatingmote.text"));
                        panel8.add(heatingmote);

                        //---- lighting ----
                        lighting.setText(bundle.getString("SaleApplication.lighting.text"));
                        panel8.add(lighting);

                        //---- buildingage ----
                        buildingage.setText(bundle.getString("SaleApplication.buildingage.text"));
                        buildingage.setHorizontalAlignment(SwingConstants.LEFT);
                        panel8.add(buildingage);

                        //---- taxation ----
                        taxation.setText(bundle.getString("SaleApplication.taxation.text"));
                        taxation.setHorizontalAlignment(SwingConstants.LEFT);
                        panel8.add(taxation);

                        //---- village ----
                        village.setText(bundle.getString("SaleApplication.village.text"));
                        village.setHorizontalAlignment(SwingConstants.LEFT);
                        panel8.add(village);

                        //---- elevator ----
                        elevator.setText(bundle.getString("SaleApplication.elevator.text"));
                        elevator.setHorizontalAlignment(SwingConstants.LEFT);
                        panel8.add(elevator);

                        //---- porperty_right ----
                        porperty_right.setText(bundle.getString("SaleApplication.porperty_right.text"));
                        porperty_right.setHorizontalAlignment(SwingConstants.LEFT);
                        panel8.add(porperty_right);

                        //---- down_payment ----
                        down_payment.setText(bundle.getString("SaleApplication.down_payment.text"));
                        down_payment.setHorizontalAlignment(SwingConstants.LEFT);
                        panel8.add(down_payment);

                        //---- selling_points ----
                        selling_points.setText(bundle.getString("SaleApplication.selling_points.text"));
                        selling_points.setHorizontalAlignment(SwingConstants.LEFT);
                        panel8.add(selling_points);

                        //---- owner_mentality ----
                        owner_mentality.setText(bundle.getString("SaleApplication.owner_mentality.text"));
                        owner_mentality.setHorizontalAlignment(SwingConstants.LEFT);
                        panel8.add(owner_mentality);

                        //---- suitable_population ----
                        suitable_population.setText(bundle.getString("SaleApplication.suitable_population.text"));
                        suitable_population.setHorizontalAlignment(SwingConstants.LEFT);
                        panel8.add(suitable_population);

                        //---- provinces ----
                        provinces.setText(bundle.getString("SaleApplication.provinces.text"));
                        provinces.setHorizontalAlignment(SwingConstants.LEFT);
                        panel8.add(provinces);

                        //---- cities ----
                        cities.setText(bundle.getString("SaleApplication.cities.text"));
                        cities.setHorizontalAlignment(SwingConstants.LEFT);
                        panel8.add(cities);

                        //---- region ----
                        region.setText(bundle.getString("SaleApplication.region.text"));
                        region.setHorizontalAlignment(SwingConstants.LEFT);
                        panel8.add(region);

                        //---- street ----
                        street.setText(bundle.getString("SaleApplication.street.text"));
                        street.setHorizontalAlignment(SwingConstants.LEFT);
                        panel8.add(street);

                        //---- specific ----
                        specific.setText(bundle.getString("SaleApplication.specific.text"));
                        specific.setHorizontalAlignment(SwingConstants.LEFT);
                        panel8.add(specific);
                    }
                    panel10.add(panel8);
                }
                panel6.add(panel10);

                //======== panel9 ========
                {
                    panel9.setLayout(new GridLayout(24, 1, 10, 5));
                    panel9.add(hname_in);

                    //---- htype_select ----
                    htype_select.setModel(new DefaultComboBoxModel<>(new String[] {
                        "\u666e\u901a\u5355\u5143\u5f0f\u4f4f\u5b85",
                        "\u516c\u5bd3\u5f0f\u4f4f\u5b85",
                        "\u590d\u5f0f\u4f4f\u5b85",
                        "\u8dc3\u5c42\u5f0f\u4f4f\u5b85",
                        "\u82b1\u56ed\u6d0b\u623f\u5f0f\u4f4f\u5b85",
                        "\u5c0f\u6237\u578b\u4f4f\u5b85"
                    }));
                    panel9.add(htype_select);
                    panel9.add(harea_in);
                    panel9.add(hprice_in);
                    panel9.add(hfloor_in);

                    //---- hdirection_select ----
                    hdirection_select.setModel(new DefaultComboBoxModel<>(new String[] {
                        "\u5317",
                        "\u5357",
                        "\u897f",
                        "\u4e1c",
                        "\u4e1c\u5317",
                        "\u4e1c\u5357",
                        "\u897f\u5317",
                        "\u897f\u5357"
                    }));
                    panel9.add(hdirection_select);

                    //---- hrenovition_select ----
                    hrenovition_select.setModel(new DefaultComboBoxModel<>(new String[] {
                        "\u7ecf\u6d4e\u578b",
                        "\u4e2d\u6863\u578b",
                        "\u9ad8\u6863\u578b",
                        "\u8c6a\u534e\u578b"
                    }));
                    panel9.add(hrenovition_select);

                    //---- buildingtype_select ----
                    buildingtype_select.setModel(new DefaultComboBoxModel<>(new String[] {
                        "\u677f\u697c",
                        "\u5854\u697c",
                        "\u677f\u5854\u7ed3\u5408"
                    }));
                    panel9.add(buildingtype_select);

                    //---- heatingmote_select ----
                    heatingmote_select.setModel(new DefaultComboBoxModel<>(new String[] {
                        "\u96c6\u4e2d\u5f0f\u4f9b\u6696",
                        "\u5bb6\u7528\u71c3\u7164\u9505\u7089",
                        "\u70ed\u51b7\u98ce\u5f0f\u7a7a\u8c03\u673a",
                        "\u5bb6\u7528\u4e2d\u592e\u7a7a\u8c03\u7cfb\u7edf",
                        "\u5bb6\u7528\u7535\u9505\u7089",
                        "\u7535\u70ed\u819c\u91c7\u6696",
                        "\u70ed\u6c34\u5730\u9762\u91c7\u6696",
                        "\u5206\u6237\u58c1\u6302\u5f0f\u71c3\u6c14\u91c7\u6696",
                        "\u667a\u80fd\u7535\u5730\u6696\u7cfb\u7edf"
                    }));
                    panel9.add(heatingmote_select);

                    //---- lighting_select ----
                    lighting_select.setModel(new DefaultComboBoxModel<>(new String[] {
                        "\u4fa7\u7a97\u91c7\u5149",
                        "\u5929\u7a97\u91c7\u5149",
                        "\u6df7\u5408\u91c7\u5149"
                    }));
                    panel9.add(lighting_select);
                    panel9.add(buildingage_in);
                    panel9.add(taxation_in);
                    panel9.add(village_in);

                    //---- elevator_select ----
                    elevator_select.setModel(new DefaultComboBoxModel<>(new String[] {
                        "\u6709",
                        "\u65e0"
                    }));
                    panel9.add(elevator_select);

                    //---- property_right_select ----
                    property_right_select.setModel(new DefaultComboBoxModel<>(new String[] {
                        "\u56fd\u6709\u623f\u4ea7",
                        "\u79c1\u6709\u623f\u4ea7",
                        "\u96c6\u4f53\u6240\u6709\u623f\u4ea7",
                        "\u80a1\u4efd\u5236\u4f01\u4e1a\u623f\u4ea7",
                        "\u8054\u8425\u4f01\u4e1a\u623f\u4ea7",
                        "\u6e2f\u3001\u6fb3\u3001\u53f0\u80de\u623f\u4ea7",
                        "\u6d89\u5916\u623f\u4ea7",
                        "\u5176\u4ed6\u623f\u4ea7"
                    }));
                    panel9.add(property_right_select);
                    panel9.add(down_payment_in);
                    panel9.add(selling_points_in);
                    panel9.add(owner_mentality_in);
                    panel9.add(suitable_population_in);
                    panel9.add(provinces_in);
                    panel9.add(cities_in);
                    panel9.add(region_in);
                    panel9.add(street_in);
                    panel9.add(specific_in);
                }
                panel6.add(panel9);
            }
            center.add(panel6, BorderLayout.NORTH);

            //======== panel11 ========
            {
                panel11.setLayout(new GridLayout(1, 2, 50, 10));

                //---- sure ----
                sure.setText(bundle.getString("SaleApplication.sure.text"));
                panel11.add(sure);

                //---- exit ----
                exit.setText(bundle.getString("SaleApplication.exit.text"));
                panel11.add(exit);
            }
            center.add(panel11, BorderLayout.CENTER);
        }
        contentPane.add(center, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

//    public void getInformation(){
//        String shname = hname_in.getText();
//        System.out.println(shname);
//       // Object sbuildingtype = buildingtype_select.getSelectedItem();
//    }

    void setMyCommandListener(MyCommandListener listener){
        this.listener=listener;
        listener.setHname_in(hname_in);
        listener.setHtype_select(htype_select);
        listener.setHarea_in(harea_in);
        listener.setHprice_in(hprice_in);
        listener.setHfloor_in(hfloor_in);
        listener.setHdirection_select(hdirection_select);
        listener.setHrenovition_select(hrenovition_select);
        listener.setBuildingtype_select(buildingtype_select);
        listener.setHeatingmote_select(heatingmote_select);
        listener.setLighting_select(lighting_select);
        listener.setBuildingage_in(buildingage_in);
        listener.setTaxation_in(taxation_in);
        listener.setVillage_in(village_in);
        listener.setElevator_select(elevator_select);
        listener.setProperty_right_select(property_right_select);
        listener.setDown_payment_in(down_payment_in);
        listener.setSelling_points_in(selling_points_in);
        listener.setOwner_mentality_in(owner_mentality_in);
        listener.setSuitable_population_in(suitable_population_in);
        listener.setProvince_in(provinces_in);
        listener.setCities_in(cities_in);
        listener.setRegion_in(region_in);
        listener.setStreet_in(street_in);
        listener.setSpecific_in(specific_in);
        sure.addActionListener(listener);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label12;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel center;
    private JPanel panel6;
    private JPanel panel10;
    private JPanel panel8;
    private JLabel hname;
    private JLabel htype;
    private JLabel harea;
    private JLabel hprice;
    private JLabel hfloor;
    private JLabel hdirectioin;
    private JLabel hrenovition;
    private JLabel buildingtype;
    private JLabel heatingmote;
    private JLabel lighting;
    private JLabel buildingage;
    private JLabel taxation;
    private JLabel village;
    private JLabel elevator;
    private JLabel porperty_right;
    private JLabel down_payment;
    private JLabel selling_points;
    private JLabel owner_mentality;
    private JLabel suitable_population;
    private JLabel provinces;
    private JLabel cities;
    private JLabel region;
    private JLabel street;
    private JLabel specific;
    private JPanel panel9;
    private JTextField hname_in;
    private JComboBox<String> htype_select;
    private JTextField harea_in;
    private JTextField hprice_in;
    private JTextField hfloor_in;
    private JComboBox<String> hdirection_select;
    private JComboBox<String> hrenovition_select;
    private JComboBox<String> buildingtype_select;
    private JComboBox<String> heatingmote_select;
    private JComboBox<String> lighting_select;
    private JTextField buildingage_in;
    private JTextField taxation_in;
    private JTextField village_in;
    private JComboBox<String> elevator_select;
    private JComboBox<String> property_right_select;
    private JTextField down_payment_in;
    private JTextField selling_points_in;
    private JTextField owner_mentality_in;
    private JTextField suitable_population_in;
    private JTextField provinces_in;
    private JTextField cities_in;
    private JTextField region_in;
    private JTextField street_in;
    private JTextField specific_in;
    private JPanel panel11;
    private JButton sure;
    private JButton exit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
