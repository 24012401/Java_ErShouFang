import java.awt.*;
import javax.swing.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * author: 刘晓霞
 * function: 更新客户信息功能实现
 * time: 2021.01.09
 */

public class WinUpdateCustomer extends JFrame {
    UpdateCustomer updateCustomer = new UpdateCustomer();
    Customer customer = new Customer();
    List<Customer> list = updateCustomer.UpdateCustomer();

    JLabel label1;
    JTextField textField1;
    JButton button1, button2, button3, button4, button5;
    static JTable table;
    JScrollPane scrollPane;
    JPanel panel1, panel2, panel3;
    DefaultTableModel defaultTableModel;

    public WinUpdateCustomer() throws Exception {

        label1 = new JLabel("请输入客户ID:");
        textField1 = new JTextField(10);
        button1 = new JButton("查询");
        panel1 = new JPanel();
        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(button1);
        this.add(panel1, BorderLayout.NORTH);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        defaultTableModel = new DefaultTableModel();
        table.setModel(defaultTableModel);
        defaultTableModel.addColumn("客户ID");
        defaultTableModel.addColumn("姓名");
        defaultTableModel.addColumn("性别");
        defaultTableModel.addColumn("电话");
        defaultTableModel.addColumn("身份证号");
        defaultTableModel.addColumn("邮箱");


    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WinUpdateCustomer updateCostomer = new WinUpdateCustomer();
                    updateCostomer.setTitle("更新客户信息");
                    updateCostomer.setBounds(450, 200, 800, 500);
                    updateCostomer.setVisible(true);
                    updateCostomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
                } catch (Exception e) {
                    e. printStackTrace();
                }
            }
        });
    }

//    public static void getId(String str, String shuxing, String zhi) {
//        PreparedStatement preparedStatement = null;
//
//        try {
//            Connection con = Link.getConnection();
//            preparedStatement = con.prepareStatement("update Custom set" +shuxing+ "= '" +zhi+"' where 客户ID = '"+str+"'" );
//            ResultSet result1 = preparedStatement.executeQuery();
//            if(result1.wasNull())
//                JOptionPane.showMessageDialog(null, "结果集中无记录");
//        } catch (ClassNotFoundException e) {
//            System.out.println("未成功加载驱动。");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("未成功打开数据库。");
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
