package com.dyx.mvcp.model;

/**
 * project name：MVCProject
 * class describe：
 * create person：dayongxin
 * create time：2016/12/21 下午5:40
 * alter person：dayongxin
 * alter time：2016/12/21 下午5:40
 * alter remark：
 */
public class UserResultModel {

    /**
     * access_token : l271a84eb5ca19eef17289afd67c8161
     * account : dayongxin
     * domain : dayongxin
     * email : dayongxin@aliyun.com
     * gender : 1
     * id : 1761
     * integral : 0
     * isemail : 0
     * isphone : 0
     * status : true
     * time : 1470061519000
     * title :
     * weiboid : 0
     */

    private String access_token;
    private String account;
    private String domain;
    private String email;
    private int gender;
    private int id;
    private int integral;
    private int isemail;
    private int isphone;
    private boolean status;
    private long time;
    private String title;
    private int weiboid;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getIsemail() {
        return isemail;
    }

    public void setIsemail(int isemail) {
        this.isemail = isemail;
    }

    public int getIsphone() {
        return isphone;
    }

    public void setIsphone(int isphone) {
        this.isphone = isphone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWeiboid() {
        return weiboid;
    }

    public void setWeiboid(int weiboid) {
        this.weiboid = weiboid;
    }
}
