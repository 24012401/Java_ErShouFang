package fhy;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchHouse {
    public ResultSet findHouseUnLimit(String attribute, String val){
        ControlJDBC db1=new ControlJDBC();
        ResultSet House1=db1.exeSql(constructUnlimitString(attribute,val));
        return House1;
    }
    public ResultSet findHouseLimit(int page) throws SQLException {
        ControlJDBC db1=new ControlJDBC();
//        System.out.println("到findHouseLimit这了");
        ResultSet House1=db1.exeSql(constructlimitString(page));
        System.out.println(House1.getString("售价"));
        return House1;
    }
    public ResultSet settingDate(String attribute,String val,int id){
        ControlJDBC db1=new ControlJDBC();
        ResultSet House=db1.exeSql(constructEdit(attribute,val,id));
        return House;
    }
    public String constructUnlimitString(String attribute,String val){
        String sql="Select * From House where "+attribute+"="+"'"+val+"'";
        //String sql="Select 售价,室内面积,房型,房源名称,楼层,朝向,装修,楼型,供暖方式,采光,建筑年代,税费,小区,电梯,产权性质,首付,核心卖点,业主心态,适宜人群,省,市,区,街道,具体 From House where "+attribute+"="+val;
        System.out.println(sql);
        return sql;
    }
    public String constructlimitString(int page){
        String sql1="Select Top "+10+" * "
                //+"房源ID,客户ID,业务员ID,售价,室内面积,房型,房源名称,楼层,朝向,装修,楼型,供暖方式,采光,建筑年代,录入时间,信息核实情况,有误位置,在售,税费,小区,电梯,产权性质,首付,核心卖点,业主心态,适宜人群,省,市,区,街道,具体  "
                +"From(Select Top " +(page*10)+" * From House Where 在售情况='在售' Order by 房源ID ) as 房源ID2 Order By 房源ID2.房源ID Desc";
        /*String sql="Select 售价,室内面积,房型,房源名称,楼层,朝向,装修,楼型,供暖方式,采光,建筑年代,税费,小区,电梯,产权性质,首付,核心卖点,业主心态,适宜人群,省,市,区,街道,具体 " +
                "From House where "+attribute+"="+val
                +" "+"Group by";*/
        return sql1;
    }
    public String constructEdit(String attribute,String val,int id){
        String sql1="Update House set "+attribute+"='"+val+"' Where 房源ID="+"'"+id+"'";
        return sql1;
    }
}
