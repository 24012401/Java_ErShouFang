package fhy;

import java.sql.ResultSet;

public class SearchSalesMan {
    public ResultSet findUnPassSale(String attribute, String val,int page){
        ControlJDBC db1=new ControlJDBC();
        ResultSet sale1=db1.exeSql(constructUnPassString(attribute,val,page));
        return sale1;
    }
    public ResultSet findPassSale(String attribute, String val,int page){
        ControlJDBC db1=new ControlJDBC();
        ResultSet sale1=db1.exeSql(constructPassString(attribute,val,page));
        return sale1;
    }
    public ResultSet turnPass(int ID){
        ControlJDBC db1=new ControlJDBC();
        ResultSet sale1=db1.exeSql(constructTurnPass(ID));
        return sale1;
    }
    public String constructUnlimitString(String attribute,String val){
        String sql="Select * From SalseMan where "+attribute+"="+val;
        return sql;
    }
    public String constructUnPassString(String attribute,String val,int page){
        String sql1="Select Top "+10+" 业务员ID,业务员姓名,业务员性别,业务员电话,工号,业务员简介  "
                +"From(Select Top "+(page*10)+" From SalseMan Users Where 业务员ID=账户ID AND 是否同一该账户使用=‘0’AND 账户类型='中介业务员' Order by 账户ID) as 账户ID2 Order By 账户ID2.账户ID Desc";
        return sql1;
    }
    public String constructPassString(String attribute,String val,int page){
        String sql1="Select Top "+10+" 业务员ID,业务员姓名,业务员性别,业务员电话,工号,业务员简介  "
                +"From(Select Top "+(page*10)+" From SalseMan Users Where 业务员ID=账户ID AND 是否同一该账户使用=‘1’AND 账户类型='中介业务员' Order by 账户ID) as 账户ID2 Order By 账户ID2.账户ID Desc";
        return sql1;
    }
    public String constructTurnPass(int ID){
        String sql1="Update Users Set 是否同意该账户使用='1' Where 账户ID="+"'"+ID+"'";
        return sql1;
    }

}
