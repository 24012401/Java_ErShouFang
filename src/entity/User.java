package entity;

/**
 * @auther 张鸿伟
 * @date 2021/1/6 10:10:34
 * @description
 */
/**
 * 项目名 BookManager
 * <br>包名 model
 * <br>描述 用户实体
 */
public class User {
    private int id;
    private String userName;
    private String password;
    public User(){super();}
    public User(String userName,String password){
        this.password = password;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
