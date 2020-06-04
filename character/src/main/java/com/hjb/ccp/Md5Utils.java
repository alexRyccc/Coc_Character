package com.hjb.ccp;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author ran_ych
 * @create 2020-05-26  10:10
 * @desc
 */
public class Md5Utils {

    /**
     *  @Description:获得md5加密串
     */
    public static String getMD5String(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}