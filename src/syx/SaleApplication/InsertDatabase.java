package syx.SaleApplication;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class InsertDatabase {

    int HouseId;
    int HomeownersId;
    int SalesManId;
    float Price;
    float CarpetArea;
    int Floor;
    Date Year;
    float Taxation;
    float DownPayments;
    Date InTime;

    java.sql.Date sqlDate;
    //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

    //数据库连接参数
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=House";
    String userName = "sa";
    String userPwd = "syx200220";

    String[] values = new String[31];
    String[] keys = {"房源ID", "客户ID", "业务员ID", "售价", "室内面积", "房型", "房源名称", "楼层", "朝向", "装修",
            "楼型", "供暖方式", "采光", "建筑年代", "税费", "小区", "电梯", "产权性质", "首付", "核心卖点",
            "业主心态", "适宜人群", "录入时间", "信息核实情况", "有误位置", "在售情况", "省", "市", "区", "街道", "具体"};

    public Date stringToDate(String time) {//时间转换
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        try {
            java.util.Date date = format.parse(time);
            sqlDate = new java.sql.Date(date.getTime());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sqlDate;
    }

    void JDBC(Map map) {

        for(int i=0;i<31;i++){
            values[i] = (String) map.get(keys[i]);
        }

        HouseId = Integer.valueOf(values[0]);
        HomeownersId = Integer.valueOf(values[1]);
        SalesManId = Integer.valueOf(values[2]);
        Price = Float.parseFloat(values[3]);
        CarpetArea = Float.parseFloat(values[4]);
        Floor = Integer.valueOf(values[7]);
        Year =stringToDate(values[13]);
        Taxation = Float.parseFloat(values[14]);
        DownPayments = Float.parseFloat(values[18]);
        InTime = stringToDate(values[22]);

        Connection dbconn = null;
        Statement st = null;

        try {
            Class.forName(driverName);
            dbconn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("success!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("fail!");
        }
        try {
            dbconn = DriverManager.getConnection(dbURL, userName, userPwd);
            st = dbconn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql3 = "insert into House values(HouseId,HomeownersId,SalesManId,Price,CarpetArea," +
                    "values[5],values[6],Floor,values[8],values[9],values[10],values[11],values[12]," +
                    "Year,Taxation,values[15],values[16],values[17],DownPayments,values[19],values[20]," +
                    "values[21],InTime,values[23],values[24],values[25],values[26],values[27],values[28]," +
                    "values[29],values[30])";
            int num = st.executeUpdate(sql3);  //update
            if (num > 0) {
                System.out.println("插入成功！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("插入失败！！");
        } finally {

            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (dbconn != null) {
                try {
                    dbconn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
