import javax.swing.*;
import java.sql.*;

/**
 * author: 刘晓霞
 * function: 主函数，程序入口，测试各部分功能
 * time: 2021.01.09
 */

public class Main {
    public static void main(String[] args) {
        WinRegister window = new WinRegister();
        window.setTitle("用户注册");
        window.setBounds(450, 200, 360, 270);
        window.setVisible(true);
//      window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //释放当前窗口
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //退出程序
    }
}
