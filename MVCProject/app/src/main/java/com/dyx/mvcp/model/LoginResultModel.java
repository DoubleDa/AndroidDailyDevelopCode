package com.dyx.mvcp.model;

/**
 * project name：MVCProject
 * class describe：
 * create person：dayongxin
 * create time：2016/12/21 下午5:32
 * alter person：dayongxin
 * alter time：2016/12/21 下午5:32
 * alter remark：
 */
public class LoginResultModel {

    /**
     * access_token : l271a84eb5ca19eef17289afd67c8161
     * id : 1761
     * refresh_token : 5fb738e174174325f9f0d8b9aa33b8a31e8e10dd5el45e906623e55d
     * status : true
     */

    private String access_token;
    private int id;
    private String refresh_token;
    private boolean status;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
