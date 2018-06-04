package com.yrf.domain.mongo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "lxrs")
public class Lxrs {
    @Id
    private String id;
    private String uname;//用户名
    @Field("lxrdetails")
    private List<LxrDetail> lxrDetails;//该用户所有联系人
    private int num;//共计联系人数量

    public Lxrs() {
    }

    public Lxrs(String uname, List<LxrDetail> lxrDetails, int num) {
        this.uname = uname;
        this.lxrDetails = lxrDetails;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public List<LxrDetail> getLxrDetails() {
        return lxrDetails;
    }

    public void setLxrDetails(List<LxrDetail> lxrDetails) {
        this.lxrDetails = lxrDetails;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
