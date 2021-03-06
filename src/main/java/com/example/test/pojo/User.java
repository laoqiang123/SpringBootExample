package com.example.test.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

//这个注解是起别名的作用，后边使用的时候就不需要全限名，简单省事
@Alias("user")
public class User implements Serializable {
    private Integer id;
    private String userName;
    private String note;
    private SexEnum sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
}
