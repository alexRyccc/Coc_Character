package com.coc.character.pojo;

import lombok.Data;

import java.util.Random;

/**
 * @author ran_ych
 * @create 2019-10-12  16:16
 * @desc
 */
@Data
public class User {
    private String name;
    private int str;
    private int agl;
    private int edu;
    private int phy;
    private int cha;
    private int vol;
    private int bod;
    private int bra;
    private int luck;
    private int age;
    private String sex;
    private String userid;
    public User(){

    }
    public User(String name, int str, int agl, int edu, int phy, int cha, int vol, int bod, int bra, int luck, int age, String sex, String userid) {
        this.name = name;
        this.str = str;
        this.agl = agl;
        this.edu = edu;
        this.phy = phy;
        this.cha = cha;
        this.vol = vol;
        this.bod = bod;
        this.bra = bra;
        this.luck = luck;
        this.age = age;
        this.sex = sex;
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getAgl() {
        return agl;
    }

    public void setAgl(int agl) {
        this.agl = agl;
    }

    public int getEdu() {
        return edu;
    }

    public void setEdu(int edu) {
        this.edu = edu;
    }

    public int getPhy() {
        return phy;
    }

    public void setPhy(int phy) {
        this.phy = phy;
    }

    public int getCha() {
        return cha;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public int getBod() {
        return bod;
    }

    public void setBod(int bod) {
        this.bod = bod;
    }

    public int getBra() {
        return bra;
    }

    public void setBra(int bra) {
        this.bra = bra;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer common(){
        Random r = new Random();
        int rx = r.nextInt(15);
        return (rx+3)*5;
    }

    public Integer special(){
        Random r = new Random();
        int rx = r.nextInt(10);
        return (rx+8)*5;
    }
    public Integer luck(){
        Random r = new Random();
        return r.nextInt(99)+1;
    }

}
