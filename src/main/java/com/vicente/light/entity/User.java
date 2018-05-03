package com.vicente.light.entity;

public class User {
    private String id;

    private String userName;

    private String password;

    private Short isFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(Short isFlag) {
        this.isFlag = isFlag;
    }
}