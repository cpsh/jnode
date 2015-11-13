package test;

import net.dreamlu.utils.StringUtil;

public class Test {

    public static void main(String[] args) {
        String pwd = "123456";
        String md5pwd = StringUtil.pwdEncrypt(pwd);
        System.out.println("pwd="+pwd+"  md5pwd="+md5pwd);

    }

}
