package cn.com.webxml;

public class Test {
    public static void main(String[] args) {
        MobileCodeWSSoap mobileCodeWSSoap = new MobileCodeWS().getMobileCodeWSSoap();
        String mobileCodeInfo = mobileCodeWSSoap.getMobileCodeInfo("17806707156",null);
        System.out.println(mobileCodeInfo);
    }
}
