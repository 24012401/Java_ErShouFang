package zhw.dao;

import zhw.SalseMan.entity.Seller;
import zhw.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @auther $张鸿伟
 * @date 2021/1/11 22:23:23
 * @description
 */
public class SellerDao {
    /**
     * 添加业务员
     *
     * @param connection 数据库连接
     * @param seller      要添加的业务员实体
     * @return int
     */
    public static int add(Connection connection, Seller seller) throws SQLException {
        String sql = "insert into dbo.SalseMan values(?,?,?,?,?,?)";
        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1,seller.getSellerId());
        psmt.setString(2, seller.getSellerName());
        psmt.setString(3, seller.getSellerSex());
        psmt.setString(4, seller.getSellerTel());
        psmt.setString(5, seller.getSellerNum());
        psmt.setString(6, seller.getSellerBrief());
        return psmt.executeUpdate();
    }
    /**
     * 列出业务员
     *
     * @param conn 数据库连接
     * @param seller  业务员实体
     * @return java.sql.ResultSet
     */
    public static ResultSet list(Connection conn, Seller seller) throws SQLException {
        //StringBuffer sb2 = new StringBuffer("select * from dbo.SalseMan ");
        StringBuffer sb = new StringBuffer("select * from dbo.SalseMan sm ,dbo.Users us where sm.业务员ID=us.账户ID");
        if (!StringUtil.isEmpty(seller.getSellerName())) {
            sb.append(" and sm.业务员姓名 like '%" + seller.getSellerName() + "%'");
        }
//        if (!StringUtil.isEmpty(seller.getSellerSex())) {
//            sb.append(" and sm.业务员性别 like '%" + seller.getSellerSex() + "%'");
//        }
//        if (!StringUtil.isEmpty(seller.getSellerTel())) {
//            sb.append(" and sm.业务员电话 like '%" + seller.getSellerTel() + "%'");
//        }
        if (seller.getSellerId()!=0) {
            sb.append(" and sm.业务员ID =" + seller.getSellerId());
        }
//        if (!StringUtil.isEmpty(seller.getSellerBrief())) {
//            sb.append(" and sm.业务员简介=" + seller.getSellerBrief());
//        }
        PreparedStatement psmt = conn.prepareStatement(sb.toString());
        return psmt.executeQuery();
    }
    /**
     * 删除业务员
     *
     * @param conn 数据库连接
     * @param id   业务员编号
     * @return int
     */
    public static int delete(Connection conn, int id) throws SQLException {
        String sql = "delete from dbo.SalseMan where 业务员ID=?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setInt(1, id);
        return psmt.executeUpdate();
    }
    /**
     * 修改业务员信息
     *
     * @param conn 数据库连接
     * @param seller 业务员实体
     * @return int
     */
    public static int update(Connection conn, Seller seller) throws SQLException {
        String sql = "update dbo.SalseMan set 业务员姓名=?,业务员性别=?,业务员电话=?,工号=?,业务员简介=? where 业务员ID=?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, seller.getSellerName());
        psmt.setString(2, seller.getSellerSex());
        psmt.setString(3, seller.getSellerTel());
        psmt.setString(4, seller.getSellerNum());
        psmt.setString(5, seller.getSellerBrief());
        psmt.setInt(6, seller.getSellerId());
        return psmt.executeUpdate();
    }
}
