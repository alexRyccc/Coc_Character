package com.coc.character.pojo.req;

/**
 * @author ran_ych
 * @create 2019-12-25  11:07
 * @desc 外围传入参数
 */
public class PersonReq {
    private String userid;
    private String name;
    private String profession;
    private String age;
    private String sex;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
