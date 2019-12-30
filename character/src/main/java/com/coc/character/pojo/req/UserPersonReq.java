package com.coc.character.pojo.req;

/**
 * @author ran_ych
 * @create 2019-12-30  18:54
 * @desc 创建账户外围参数
 */
public class UserPersonReq {
    private String username;
    private String password;
    private String phone;

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
}
