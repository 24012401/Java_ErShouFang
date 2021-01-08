
/**
 * author: 刘晓霞
 * function: 用户注册类
 * time: 2021.01.09
 */

public class Register {
    int id;
    String password;
    String zhangHuLeiXing;

    public void setPassword(String password) {
        this.password = password;
    }
    public void setZhangHuLeiXing(String zhangHuLeiXing) {
        this.zhangHuLeiXing = zhangHuLeiXing;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }
    public String getZhangHuLeiXing() {
        return zhangHuLeiXing;
    }
}
