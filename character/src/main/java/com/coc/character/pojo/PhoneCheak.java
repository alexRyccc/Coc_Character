package com.coc.character.pojo;

import com.coc.character.Util.DateTimeUtils;

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

    public void setSmsdt(String smsdt) {
        this.smsdt = String.valueOf(DateTimeUtils.getCurrentLocalDate());
    }

    public String getSmstm() {
        return smstm;
    }

    public void setSmstm(String smstm) {
        this.smstm = String.valueOf(DateTimeUtils.getCurrentLocalTime());
    }
}
