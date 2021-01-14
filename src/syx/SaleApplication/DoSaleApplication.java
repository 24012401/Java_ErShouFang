package syx.SaleApplication;

public class DoSaleApplication {
    public static void main(String[] args){
//        SaleApplicationNotice san = new SaleApplicationNotice();
//        san.setBounds(100,100,450,260);
//        san.setTitle("测试");

//        String housename;
//        House house = new House();

        SaleApplication sa = new SaleApplication();
        SaleApplicationListen sal = new SaleApplicationListen();
        sa.setMyCommandListener(sal);
        sa.setBounds(100,100,450,900);
        sa.setTitle("测试2");
    }
}
