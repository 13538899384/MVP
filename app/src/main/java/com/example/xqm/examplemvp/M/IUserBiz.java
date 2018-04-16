package com.example.xqm.examplemvp.M;

/**
 * 定义view业务接口，登陆
 * Created by XQM on 2018/4/15.
 */

public interface IUserBiz {
    public void login(String userName, String userPwd, OnLoginListener onLoginListener);
}
