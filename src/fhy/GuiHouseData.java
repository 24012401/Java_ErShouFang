package fhy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuiHouseData {
    ArrayList<House> houses;
    GuiHouseData(ResultSet result) throws SQLException {
        houses=new ArrayList<House>();
        do{
            House hou=new House();
            hou.setHouseId(result.getInt("房源ID"));
            System.out.println(result.getString("房源名称"));
            hou.setHomeownersId(result.getInt("客户ID"));
            //System.out.println("到GuiHouseData了");
            hou.setSalseManId(result.getInt("业务员ID"));
            hou.setPrice(result.getFloat("售价"));
            hou.setCarpetArea(result.getFloat("室内面积"));
            hou.setHouseType(result.getString("房型"));
            hou.setHouseName(result.getString("房源名称"));
            hou.setFloor(result.getString("楼层"));
            hou.setOrientation(result.getString("朝向"));
            hou.setRenovation(result.getString("装修"));
            hou.setBuildingType(result.getString("楼型"));
            hou.setHeatingMode(result.getString("供暖方式"));
            hou.setLighting(result.getString("采光"));
            hou.setYear(result.getString("建筑年代"));
            hou.setTaxation(result.getString("税费"));
            hou.setNeighbourhood(result.getString("小区"));
            hou.setElevator(result.getString("电梯"));
            hou.setProperty(result.getString("产权性质"));
            hou.setDownPayments(result.getString("首付"));
            hou.setSellingPoint(result.getString("核心卖点"));
            hou.setMentality(result.getString("业主心态"));
            hou.setSuitablePopulation(result.getString("适宜人群"));
            hou.setIntime(result.getDate("录入时间"));
            hou.setCheck(result.getString("信息核实情况"));
            hou.setWrongPlace(result.getString("有误位置"));
            hou.setIsSelling(result.getString("在售情况"));
            hou.setProvince(result.getString("省"));
            hou.setCity(result.getString("市"));
            hou.setTown(result.getString("区"));
            hou.setStreet(result.getString("街道"));
            hou.setDetail(result.getString("具体"));
            houses.add(hou);
            System.out.println("到这了"+houses.size());
        }while(result.next()!=false);
        result.close();
    }
    public House returnHouse(int i){
        return houses.get(i);
    }
    public int housesNumber(){//返回房子数组中房子的数量
        return houses.size();
    }
}
