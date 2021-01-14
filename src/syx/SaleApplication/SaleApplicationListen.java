package syx.SaleApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class SaleApplicationListen extends MyCommandListener {
    Random random = new Random();
    JTextField hname_in;
    JComboBox htype_select;
    JTextField harea_in;
    JTextField hprice_in;
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

    //传入数据库的变量
    private String HouseId;
    private String HomeownersId;
    private String SalesManId;
    private String HouseType;
    private String HouseName;
    private String Floor;
    private String Orientation;
    private String Renovation;
    private String BuildingType;
    private String HeatingMode;
    private String Lighting;
    private String Year;//建筑年份
    private String Taxation;
    private String Neighbourhood;
    private String Property;
    private String DownPayments;
    private String SellingPoint;
    private String Mentality;
    private String SuitablePopulation;
    private String Intime;
    private String Check;
    private String WrongPlace;
    private String IsSelling;
    private String Province;
    private String City;
    private String Town;
    private String Street;
    private String Detail;
    private float Price;
    private float CarpetArea;//房屋面积
    private boolean Elevator;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    House house = new House();
    InsertDatabase insertDatabase = new InsertDatabase();

    Map<String, String> map = new HashMap<String,String>();

    @Override
    public void actionPerformed(ActionEvent e) {

        Map map1 = getInformation();
        insertDatabase.JDBC(map1);
//        //获取Map中的所有key
//        Set<String> keySet = map.keySet();
//        //遍历存放所有key的Set集合
//        Iterator<String> it =keySet.iterator();
//        while(it.hasNext()){                         //利用了Iterator迭代器**
//            //得到每一个key
//            String key = it.next();
//            //通过key获取对应的value
//            String value = map.get(key);
//            System.out.println(key+"="+value);
//        }


//        System.out.println(house.getHouseId());
//        System.out.println(house.getHouseName());
//        System.out.println(house.getBuildingType());
//        System.out.println(house.getIntime());
//        System.out.println(house.getFloor());
//        System.out.println(house.getTaxation());
    }

    Map getInformation(){
        //声明所有获取信息变量
        String shname = hname_in.getText();
        String shtype = (String) htype_select.getSelectedItem();
        float sharea = Float.parseFloat(harea_in.getText());
        float shprice = Float.parseFloat(hprice_in.getText());
        String shfloor = hfloor_in.getText();
        String sdirection = (String)hdirection_select.getSelectedItem();
        String srenovition = (String) hrenovition_select.getSelectedItem();
        String sbuildingtype = (String) buildingtype_select.getSelectedItem();
        String sheatingmote = (String) heatingmote_select.getSelectedItem();
        String slighting = (String) lighting_select.getSelectedItem();
        String sbuildingage = buildingage_in.getText();
        String staxation = taxation_in.getText();
        String svillage = village_in.getText();
        String selevator = (String) elevator_select.getSelectedItem();
        String sproperty_right = (String) property_right_select.getSelectedItem();
        String sdown_payment = down_payment_in.getText();
        String sselling_points = selling_points_in.getText();
        String sowner_mentality = owner_mentality_in.getText();
        String ssuitable_population = suitable_population_in.getText();
        String sprovince = provinces_in.getText();
        String scity = cities_in.getText();
        String sregion = region_in.getText();
        String sstreet = street_in.getText();
        String sspecific = specific_in.getText();
        boolean elevator;
        String hid = random.nextInt(100)+"";
        String hownerid = random.nextInt(100)+"";
        String salesmanid = random.nextInt(100)+"";
        String intime = df.format(new Date());

        if (selevator=="是") {
            elevator=true;
        }else{
            elevator=false;
        }

        //卖家手动输入
        house.setHouseName(shname);
        house.setHouseType(shtype);
        house.setCarpetArea(sharea);
        house.setPrice(shprice);
        house.setFloor(shfloor);
        house.setOrientation(sdirection);
        house.setRenovation(srenovition);
        house.setBuildingType(sbuildingtype);
        house.setHeatingMode(sheatingmote);
        house.setLighting(slighting);
        house.setYear(sbuildingage);
        house.setTaxation(staxation);
        house.setNeighbourhood(svillage);
        house.setElevator(elevator);
        house.setProperty(sproperty_right);
        house.setDownPayments(sdown_payment);
        house.setSellingPoint(sselling_points);
        house.setMentality(sowner_mentality);
        house.setSuitablePopulation(ssuitable_population);
        house.setProvince(sprovince);
        house.setCity(scity);
        house.setTown(sregion);
        house.setStreet(sstreet);
        house.setDetail(sspecific);

        //系统默认设置
        house.setHouseId(hid);
        house.setHomeownersId(hownerid);
        house.setSalesManId(salesmanid);
        house.setIntime(intime);
        house.setCheck("未");
        house.setWrongPlace("无");
        house.setIsSelling("在售");


        //从house变量中取出
        HouseId = house.getHouseId();
        HomeownersId = house.getHomeownersId();
        SalesManId = house.getSalesManId();
        HouseType = house.getHouseType();
        HouseName = house.getHouseName();
        Floor = house.getFloor();
        Orientation = house.getOrientation();
        Renovation = house.getRenovation();
        BuildingType = house.getBuildingType();
        HeatingMode = house.getHeatingMode();
        Lighting = house.getLighting();
        Year = house.getYear();
        Taxation = house.getTaxation();
        Neighbourhood = house.getNeighbourhood();
        Property = house.getProperty();
        DownPayments = house.getDownPayments();
        SellingPoint = house.getSellingPoint();
        Mentality = house.getMentality();
        SuitablePopulation = house.getSuitablePopulation();
        Intime = house.getIntime();
        Check = house.getCheck();
        WrongPlace = house.getWrongPlace();
        IsSelling = house.getIsSelling();
        Province = house.getProvince();
        City = house.getCity();
        Town = house.getTown();
        Street = house.getStreet();
        Detail = house.getDetail();
        Price = house.getPrice();
        CarpetArea = house.getCarpetArea();
        Elevator = house.isElevator();

        map.put("房源ID",HouseId);
        map.put("客户ID",HomeownersId);
        map.put("业务员ID",SalesManId);
        map.put("售价",String.valueOf(Price));
        map.put("室内面积",String.valueOf(CarpetArea));
        map.put("房型",HouseType);
        map.put("房源名称",HouseName);
        map.put("楼层",Floor);
        map.put("朝向",Orientation);
        map.put("装修",Renovation);
        map.put("楼型",BuildingType);
        map.put("供暖方式",HeatingMode);
        map.put("采光",Lighting);
        map.put("建筑年代",Year);
        map.put("税费",Taxation);
        map.put("小区",Neighbourhood);
        map.put("电梯",String.valueOf(Elevator));
        map.put("产权性质",Property);
        map.put("首付",DownPayments);
        map.put("核心卖点",SellingPoint);
        map.put("业主心态",Mentality);
        map.put("适宜人群",SuitablePopulation);
        map.put("录入时间",Intime);
        map.put("信息核实情况",Check);
        map.put("有误位置",WrongPlace);
        map.put("在售情况",IsSelling);
        map.put("省",Province);
        map.put("市",City);
        map.put("区",Town);
        map.put("街道",Street);
        map.put("具体",Detail);

        return map;
    }

    @Override
    public void setHname_in(JTextField hname_in) {
        this.hname_in = hname_in;
    }

    @Override
    public void setHtype_select(JComboBox htype_select) {
        this.htype_select=htype_select;
    }

    @Override
    public void setHarea_in(JTextField harea_in) {
        this.harea_in = harea_in;
    }

    @Override
    public void setHprice_in(JTextField hprice_in) {
        this.hprice_in = hprice_in;
    }

    @Override
    public void setHfloor_in(JTextField hfloor_in) {
        this.hfloor_in = hfloor_in;
    }

    @Override
    public void setHdirection_select(JComboBox hdirection_select) {
        this.hdirection_select = hdirection_select;
    }

    @Override
    public void setHrenovition_select(JComboBox hrenovition_select) {
        this.hrenovition_select = hrenovition_select;
    }

    @Override
    public void setBuildingtype_select(JComboBox buildingtype_select) {
        this.buildingtype_select = buildingtype_select;
    }

    @Override
    public void setHeatingmote_select(JComboBox heatingmote_select) {
        this.heatingmote_select = heatingmote_select;
    }

    @Override
    public void setLighting_select(JComboBox lighting_select) {
        this.lighting_select = lighting_select;
    }

    @Override
    public void setBuildingage_in(JTextField buildingage_in) {
        this.buildingage_in = buildingage_in;
    }

    @Override
    public void setTaxation_in(JTextField taxation_in) {
        this.taxation_in = taxation_in;
    }

    @Override
    public void setVillage_in(JTextField village_in) {
        this.village_in = village_in;
    }

    @Override
    public void setElevator_select(JComboBox elevator_select) {
        this.elevator_select = elevator_select;
    }

    @Override
    public void setProperty_right_select(JComboBox property_right_select) {
        this.property_right_select = property_right_select;
    }

    @Override
    public void setDown_payment_in(JTextField down_payment_in) {
        this.down_payment_in = down_payment_in;
    }

    @Override
    public void setSelling_points_in(JTextField selling_points_in) {
        this.selling_points_in = selling_points_in;
    }

    @Override
    public void setOwner_mentality_in(JTextField owner_mentality_in) {
        this.owner_mentality_in = owner_mentality_in;
    }

    @Override
    public void setSuitable_population_in(JTextField suitable_population_in) {
        this.suitable_population_in = suitable_population_in;
    }

    @Override
    public void setProvince_in(JTextField province_in) {
        this.provinces_in = province_in;
    }

    @Override
    public void setCities_in(JTextField cities_in) {
        this.cities_in = cities_in;
    }

    @Override
    public void setRegion_in(JTextField region_in) {
        this.region_in = region_in;
    }

    @Override
    public void setStreet_in(JTextField street_in) {
        this.street_in = street_in;
    }

    @Override
    public void setSpecific_in(JTextField specific_in) {
        this.specific_in = specific_in;
    }
}
