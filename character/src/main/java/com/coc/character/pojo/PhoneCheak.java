package com.coc.character.pojo;

import com.coc.character.Util.DateTimeUtils;
import com.coc.character.Util.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ran_ych
 * @create 2020-01-20  17:01
 * @desc
 */
public class PhoneCheak {
    //短信编号
    private String smsnumber;
    private String username;
    private String password;
    private String phone;
    //登录短信1/注册短信0/其他
    private String status;
    //是否免短信0免
    private String smsfree;

    //短信生成日期
    private String smsdt;
    //短信生成时间
    private String smstm;

    public String getSmsnumber() {
        return smsnumber;
    }

    public void setSmsnumber(String smsnumber) {
        this.smsnumber = smsnumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSmsfree() {
        return smsfree;
    }

    public void setSmsfree(String smsfree) {
        this.smsfree = smsfree;
    }

    public String getSmsdt() {
        return smsdt;
    }

    public void setSmsdt() {
        this.smsdt = String.valueOf(DateTimeUtils.getCurrentLocalDate());
    }

    public String getSmstm() {
        return smstm;
    }

    public void setSmstm() {
        this.smstm = String.valueOf(DateTimeUtils.getCurrentLocalTime());
    }

    public boolean haveTruePhone( ){
        if (isMobile(this.phone)){
            return false;
        }
        return true;

    }
    public  boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        String s2="^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$";// 验证手机号
        if(StringUtil.isBlank(str)){
            p = Pattern.compile(s2);
            m = p.matcher(str);
            b = m.matches();
        }
        return b;
    }
}
