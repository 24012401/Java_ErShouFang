package zhw.entity;

import java.io.Serializable;

/**
 * @auther 张鸿伟
 * @date 2021/1/11 11:25:39
 * @description
 */
public class HouseType implements Serializable {
    private Integer id;
    private String houseTypeName;
    private String houseTypeDesc;
    @Override
    public String toString(){
        return this.houseTypeName;
    }
    public HouseType(){
        super();
    }
    public HouseType(Integer id,String houseTypeName,String houseTypeDesc){
        this.id = id;
        this.houseTypeName = houseTypeName;
        this.houseTypeDesc = houseTypeDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseTypeName() {
        return houseTypeName;
    }

    public void setHouseTypeName(String houseTypeName) {
        this.houseTypeName = houseTypeName;
    }

    public String getHouseTypeDesc() {
        return houseTypeDesc;
    }

    public void setHouseTypeDesc(String houseTypeDesc) {
        this.houseTypeDesc = houseTypeDesc;
    }
}
