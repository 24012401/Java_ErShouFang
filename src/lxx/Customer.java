package lxx;

/**
 * author: 刘晓霞
 * function: 客户类：客户基本信息功能实现
 * time: 2021.01.10
 */
public class Customer {
    private String id;
    private String name;
    private String sex;
    private String phone;
    private String card;
    private String mail;

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setCard(String card) {
        this.card = card;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSex() {
        return sex;
    }
    public String getPhone() {
        return phone;
    }
    public String getCard() {
        return card;
    }
    public String getMail() {
        return mail;
    }
}
