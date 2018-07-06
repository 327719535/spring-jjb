package com.util;


import com.techec.entity.personal.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
    //private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void encryptPassword(User user) {
        //String salt=randomNumberGenerator.nextBytes().toHex();
        String newPassword = new SimpleHash(algorithmName, user.getPswd(), ByteSource.Util.bytes(user.getNickname()), hashIterations).toHex();
        //String newPassword = new SimpleHash(algorithmName, User.getPassword()).toHex();
        user.setPswd(newPassword);

    }
}
