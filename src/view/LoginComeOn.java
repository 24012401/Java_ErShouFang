package view;

import java.sql.*;

/**
 * @auther 张鸿伟
 * @date 2021/1/10 17:50:55
 * @description
 */
public class LoginComeOn {
    private static Connection dbConn = null;

    public static void main(String[] args) {
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=ErShouFang";//数据库路径
        String name = "sa";                                                            //数据库账号
        String password = "mima0305";//数据库密码
//        String select = "select * from [wryStudent3]";//简单查询语句
//        String update = "update [wryStudent3] set Ssex='女' where Sno='9512110'";
//        String insert="insert into Course(Cno,Cname,Ccredit,XKLB) values('X02','English','5','必修')";
//        String delete="delete  from [Course] where Cno='X02'";
        try {
            //1.加载驱动
            //Class.forName方法的作用,就是初始化给定的类.而我们给定的MySQL的Driver类中,
            // 它在静态代码块中通过JDBC的DriverManager注册了一下驱动.我们也可以直接使用JDBC的驱动管理器注册mysql驱动.
            // 从而代替使用Class.forName.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //2.连接
            dbConn = DriverManager.getConnection(dbURL, name, password);
            System.out.println("连接数据库成功！");
//            PreparedStatement statement = null;
//
//            statement = dbConn.prepareStatement(select);
//
//            ResultSet res = null;
//            res = statement.executeQuery();
//            //当查询下一行有记录时：res.next()返回值为true，反之为false
//            while (res.next()) {
//                String Sno = res.getString("Sno");
//                String Sname = res.getString("Sname");
//                String Ssex = res.getString("Ssex");
//                System.out.println("学号：" + Sno + "姓名：" + Sname + " 性别：" + Ssex);
//            }
//
//            //修改
//            statement = dbConn.prepareStatement(update);
//            int res1 = statement.executeUpdate();
//            System.out.println(res1);
//
//            //添加
//            statement = dbConn.prepareStatement(insert);
//            int res2=statement.executeUpdate();
//            System.out.println(res2);
//
//            //删除
//            statement = dbConn.prepareStatement(delete);
//            int res3=statement.executeUpdate();
//            System.out.println(res3);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接数据库失败！");
        }
    }

}
