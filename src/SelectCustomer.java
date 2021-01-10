import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * author: 刘晓霞
 * function: 查询客户信息功能实现
 * time: 2021.01.10
 */

public class SelectCustomer {
    List<Customer> list1 = new ArrayList<Customer>();
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet = null;

    // 将数据库数据导出
    public List<Customer> UpdateCustomer() throws Exception {
        connection = Link.getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String str = "select * from Customer";
        try {
            resultSet = statement.executeQuery(str);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            while(resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getString("客户ID"));
                customer.setName(resultSet.getString("姓名"));
                customer.setSex(resultSet.getString("性别"));
                customer.setPhone(resultSet.getString("电话"));
                customer.setCard(resultSet.getString("身份证号"));
                customer.setMail(resultSet.getString("邮箱"));
                list1.add(customer);
            }
            Link.result(connection,statement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list1;
    }

//    public String update(String rid, String rname, String rsex, String rphone, String rcard, String rmail) throws Exception {
//        int result = -1;
//        connection = Link.getConnection();
//        String str = "update Customer set 姓名 =?,性别=?,电话=?,身份证号=?,邮箱=? where 客户ID=?";
//        preparedStatement = connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);
//        preparedStatement.setString(1, rname);
//        preparedStatement.setString(2, rsex);
//        preparedStatement.setString(3, rphone);
//        preparedStatement.setString(4, rcard);
//        preparedStatement.setString(5, rmail);
//        preparedStatement.setString(6, rid);
//        try{
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        try {
//            result = preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            Link.result(connection, preparedStatement);
//            if (result > 0){
//                return "修改成功！";
//            } else {
//                return "修改失败！";
//            }
//        }
//    }

    public String[] select(String id) throws Exception {
        String[] str = new String[6];
        connection = Link.getConnection();
        String sql = "select * from Customer where 客户ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            preparedStatement.setString(1, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                str[0] = resultSet.getString("客户ID");
                str[1] = resultSet.getString("姓名");
                str[2] = resultSet.getString("性别");
                str[3] = resultSet.getString("电话");
                str[4] = resultSet.getString("身份证号");
                str[5] = resultSet.getString("邮箱");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Link.result(connection, preparedStatement);
        }
        return str;
    }
}
