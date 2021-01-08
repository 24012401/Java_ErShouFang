
/**
 * author: 刘晓霞
 * function: 用户登录类
 * time: 2021.01.09
 */

public class Login {

    boolean loginSuccess = false;
    String id;
    String password;

    public void setId(String id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public boolean getLoginSuccess() {
        return loginSuccess;
    }
}
