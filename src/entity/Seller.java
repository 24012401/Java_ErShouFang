package entity;

import java.io.Serializable;

/**
 * @auther $张鸿伟
 * @date 2021/1/11 21:59:01
 * @description
 */
public class Seller implements Serializable {
    private int sellerId;
    private String sellerName;
    private String sellerSex;
    private String sellerTel;
    private String sellerNum;
    private String sellerBrief;

    public Seller(int sellerId, String sellerName, String sellerSex, String sellerTel, String sellerNum, String sellerBrief) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.sellerSex = sellerSex;
        this.sellerTel = sellerTel;
        this.sellerNum = sellerNum;
        this.sellerBrief = sellerBrief;
    }
    public Seller( String sellerName, String sellerSex, String sellerTel, String sellerNum, String sellerBrief) {
        this.sellerName = sellerName;
        this.sellerSex = sellerSex;
        this.sellerTel = sellerTel;
        this.sellerNum = sellerNum;
        this.sellerBrief = sellerBrief;
    }
    public Seller(String sellerName,int sellerId){
        this.sellerName = sellerName;
        this.sellerId = sellerId;
    }
    public Seller(String sellerName){
        this.sellerName = sellerName;
    }
    public Seller(){
        super();
    };

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerSex() {
        return sellerSex;
    }

    public void setSellerSex(String sellerSex) {
        this.sellerSex = sellerSex;
    }

    public String getSellerTel() {
        return sellerTel;
    }

    public void setSellerTel(String sellerTel) {
        this.sellerTel = sellerTel;
    }

    public String getSellerNum() {
        return sellerNum;
    }

    public void setSellerNum(String sellerNum) {
        this.sellerNum = sellerNum;
    }

    public String getSellerBrief() {
        return sellerBrief;
    }

    public void setSellerBrief(String sellerBrief) {
        this.sellerBrief = sellerBrief;
    }
}
