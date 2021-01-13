package zhw.entity;

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
    private String id;
    private String userType;
    private String password;
    public User(){super();}
    public User(String userID,String password){
        this.password = password;
        this.id = userID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userName) {
        this.userType = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
