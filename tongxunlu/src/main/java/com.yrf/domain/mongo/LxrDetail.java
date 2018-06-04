package com.yrf.domain.mongo;

import java.util.Date;

public class LxrDetail {
    private String lxrname;
    private String lxrtel;
    private Date addtime;
    private int status;

   public LxrDetail(){}
    public LxrDetail(String lxrname, String lxrtel, Date addtime,int status) {
        this.lxrname = lxrname;
        this.lxrtel = lxrtel;
        this.addtime = addtime;
        this.status = status;
    }

    public String getLxrname() {
        return lxrname;
    }

    public void setLxrname(String lxrname) {
        this.lxrname = lxrname;
    }

    public String getLxrtel() {
        return lxrtel;
    }

    public void setLxrtel(String lxrtel) {
        this.lxrtel = lxrtel;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
