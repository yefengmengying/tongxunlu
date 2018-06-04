package com.yrf.domain.mysql;

import java.util.Date;

public class Users {
    private int uid;
    private String uname;
    private String upwd;
    private int authority;
    private Date addtime;

    public Users() {
    }

    public Users(String uname, String upwd,int authority) {
        this.uname = uname;
        this.upwd = upwd;
        this.authority = authority;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }
}
