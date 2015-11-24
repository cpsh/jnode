package test;

import com.jfinal.ext.plugin.redis.JedisKit;

import redis.clients.jedis.Jedis;
import net.dreamlu.utils.StringUtil;

public class Test {

    public static void main(String[] args) {
        String pwd = "123456";
        String md5pwd = StringUtil.pwdEncrypt(pwd);
        System.out.println("pwd="+pwd+"  md5pwd="+md5pwd);
     
        JedisKit.set("jediskey", "this is a test from jediskit!");
    }

}
