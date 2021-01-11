package zhw.dao;

import zhw.entity.User;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @auther 张鸿伟
 * @date 2021/1/6 10:14:17
 * @description
 */
public class UserDao {
/**
 * 用户登录
 *
 * @param connection 数据库连接
 * @param user       用户实体
 * @return entity.User
 */
    public User login(Connection connection,User user) throws SQLException {
        User resultUser = null;
        String sql = "select 账户类型 from Users where 账户ID=? and 密码=?";
//        String sql = "select 密码 from Users where 账户ID=?";
        PreparedStatement psmt =connection.prepareStatement(sql);
        psmt.setString(1,user.getId());
        psmt.setString(2,user.getPassword());
        ResultSet resultSet =psmt.executeQuery();

//        String password = resultSet.getString("密码");
//        if (password.equals(user.getPassword())) {
//
//        }
        if(resultSet.next()){
            resultUser = new User();
//            resultUser.setId(resultSet.getString("账户ID"));
            resultUser.setUserType(resultSet.getString("账户类型"));
//            resultUser.setPassword(resultSet.getString("密码"));
        }
//        do{
//            resultUser = new User();
//            resultUser.setId(resultSet.getInt("账户ID"));
//            resultUser.setUserName(resultSet.getString("账户ID"));
//            resultUser.setPassword(resultSet.getString("密码"));
//        }while (resultSet.next());
        return resultUser;
    }
}
