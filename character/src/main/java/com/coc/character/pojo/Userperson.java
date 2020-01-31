package com.coc.character.pojo;

import com.coc.character.Util.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

public class Userperson {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userperson.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userperson.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userperson.creattime
     *
     * @mbg.generated
     */
    private String creattime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userperson.uname
     *
     * @mbg.generated
     */
    private String uname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userperson.phone
     *
     * @mbg.generated
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userperson.vip
     *
     * @mbg.generated
     */
    private Integer vip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userperson.levels
     *
     * @mbg.generated
     */
    private Integer levels;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userperson.rmk
     *
     * @mbg.generated
     */
    private String rmk;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userperson.cardid1
     *
     * @mbg.generated
     */
    private String cardid1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userperson.cardid2
     *
     * @mbg.generated
     */
    private String cardid2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userperson.cardid3
     *
     * @mbg.generated
     */
    private String cardid3;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userperson.cardid4
     *
     * @mbg.generated
     */
    private String cardid4;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userperson.cardid5
     *
     * @mbg.generated
     */
    private String cardid5;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userperson.username
     *
     * @return the value of userperson.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userperson.username
     *
     * @param username the value for userperson.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userperson.password
     *
     * @return the value of userperson.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userperson.password
     *
     * @param password the value for userperson.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userperson.creattime
     *
     * @return the value of userperson.creattime
     *
     * @mbg.generated
     */
    public String getCreattime() {
        return creattime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userperson.creattime
     *
     * @param creattime the value for userperson.creattime
     *
     * @mbg.generated
     */
    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userperson.uname
     *
     * @return the value of userperson.uname
     *
     * @mbg.generated
     */
    public String getUname() {
        return uname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userperson.uname
     *
     * @param uname the value for userperson.uname
     *
     * @mbg.generated
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userperson.phone
     *
     * @return the value of userperson.phone
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userperson.phone
     *
     * @param phone the value for userperson.phone
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userperson.vip
     *
     * @return the value of userperson.vip
     *
     * @mbg.generated
     */
    public Integer getVip() {
        return vip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userperson.vip
     *
     * @param vip the value for userperson.vip
     *
     * @mbg.generated
     */
    public void setVip(Integer vip) {
        this.vip = vip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userperson.levels
     *
     * @return the value of userperson.levels
     *
     * @mbg.generated
     */
    public Integer getLevels() {
        return levels;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userperson.levels
     *
     * @param levels the value for userperson.levels
     *
     * @mbg.generated
     */
    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userperson.rmk
     *
     * @return the value of userperson.rmk
     *
     * @mbg.generated
     */
    public String getRmk() {
        return rmk;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userperson.rmk
     *
     * @param rmk the value for userperson.rmk
     *
     * @mbg.generated
     */
    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userperson.cardid1
     *
     * @return the value of userperson.cardid1
     *
     * @mbg.generated
     */
    public String getCardid1() {
        return cardid1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userperson.cardid1
     *
     * @param cardid1 the value for userperson.cardid1
     *
     * @mbg.generated
     */
    public void setCardid1(String cardid1) {
        this.cardid1 = cardid1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userperson.cardid2
     *
     * @return the value of userperson.cardid2
     *
     * @mbg.generated
     */
    public String getCardid2() {
        return cardid2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userperson.cardid2
     *
     * @param cardid2 the value for userperson.cardid2
     *
     * @mbg.generated
     */
    public void setCardid2(String cardid2) {
        this.cardid2 = cardid2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userperson.cardid3
     *
     * @return the value of userperson.cardid3
     *
     * @mbg.generated
     */
    public String getCardid3() {
        return cardid3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userperson.cardid3
     *
     * @param cardid3 the value for userperson.cardid3
     *
     * @mbg.generated
     */
    public void setCardid3(String cardid3) {
        this.cardid3 = cardid3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userperson.cardid4
     *
     * @return the value of userperson.cardid4
     *
     * @mbg.generated
     */
    public String getCardid4() {
        return cardid4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userperson.cardid4
     *
     * @param cardid4 the value for userperson.cardid4
     *
     * @mbg.generated
     */
    public void setCardid4(String cardid4) {
        this.cardid4 = cardid4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userperson.cardid5
     *
     * @return the value of userperson.cardid5
     *
     * @mbg.generated
     */
    public String getCardid5() {
        return cardid5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userperson.cardid5
     *
     * @param cardid5 the value for userperson.cardid5
     *
     * @mbg.generated
     */
    public void setCardid5(String cardid5) {
        this.cardid5 = cardid5;
    }


    public boolean haveTrueUsername( ){
        if (this.username==null||this.username.length()>12||this.username.length()<6||isUpperCase(this.username.charAt(0))){
            return false;
        }
        return true;

    }
    public boolean haveTruePassword( ){

        if (this.password==null||this.password.length()>12||this.password.length()<6){
            return false;
        }
        return true;

    }
    public boolean haveTruePhone( ){
        if (isMobile(this.phone)){
            return false;
        }
        return true;

    }

    public boolean isUpperCase(char d) {
        char c =d;
        return c >=65 && c <= 90 &&c >= 97&& c <= 122;
    }

    /**
     * 密码不区分大小写
     * @param password
     * @return
     */
    public String changePassword(String password){
        return toLowerCase(password);
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