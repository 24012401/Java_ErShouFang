package zhw.SalseMan.dao;

import zhw.SalseMan.entity.House;
import zhw.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @auther $张鸿伟
 * @date 2021/1/11 15:03:27
 * @description
 */
public class HouseDao {
    /**
     * 添加房源
     *
     * @param connection 数据库连接
     * @param house       要添加的房源实体
     * @return int
     */
//    public static int add(Connection conn, House house){
//
//    }
/**
 * 列出房源
 *
 * @param conn 数据库连接
 * @param house 房源实体
 * @return java.sql.ResultSet
 */
public static ResultSet list(Connection conn, House house) throws SQLException {
    StringBuffer sb = new StringBuffer("select * from dbo.House h where");
    if (!StringUtil.isEmpty(house.getHouseName())) {
        sb.append(" h.房源名称 like '%" + house.getHouseName() + "%'");
    }
    if (house.getSellerManId()!=null) {
        sb.append(" and h.业务员ID like '%" + house.getSellerManId() + "%'");
    }
    if (house.getHouseType() != null) {
        sb.append(" and h.房型=" + house.getHouseType());
    }
    PreparedStatement psmt = conn.prepareStatement(sb.toString());
    return psmt.executeQuery();
}
}
