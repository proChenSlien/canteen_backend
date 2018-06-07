package com.cp.utils;


import com.cp.domain.User;
import com.cp.domain.UserApi;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * TODO 密码工具
 *
 * @author liufeng
 */
public class PasswordHelper {
    private static String algorithmName = "md5";
    private static int hashIterations = 2;

    public static void encryptPassword(User user) {
        String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getUsername()), hashIterations).toHex();
        user.setPassword(newPassword);

    }

    public static void encryptPassword(UserApi user) {
        String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getUserName()), hashIterations).toHex();
        user.setPassword(newPassword);

    }

    public static void main(String[] args) {
        PasswordHelper passwordHelper = new PasswordHelper();
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        passwordHelper.encryptPassword(user);
        System.out.println(user.getPassword());
    }
}
