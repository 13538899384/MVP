package com.example.xqm.examplemvp.M;

/**
 * Created by XQM on 2018/4/15.
 */

public class User {
    private String userName;
    private String userPwd;
    private boolean flag;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
