import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UpdateCustomer {
    List<Customer> list1 = new ArrayList<Customer>();
    Connection connection;
    Statement statement;
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
                customer.setId(resultSet.getString("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSex(resultSet.getString("sex"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setCard(resultSet.getString("card"));
                customer.setMail(resultSet.getString("mail"));
                list1.add(customer);
            }
            Link.result(connection,statement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list1;
    }

    // 添加数据入库


}
