package fhy;

public class Salesman {
    private String
            salesManName
            ,sex
            ,salenPhone
            ,jobNumber
            ,introduction;
    private int salesmanId;

    public int getSalesmanId() {
        return salesmanId;
    }

    public String getSalesManName() {
        return salesManName;
    }

    public String getSex() {
        return sex;
    }

    public String getSalenPhone() {
        return salenPhone;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }

    public void setSalesManName(String salesManName) {
        this.salesManName = salesManName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSalenPhone(String salenPhone) {
        this.salenPhone = salenPhone;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}

