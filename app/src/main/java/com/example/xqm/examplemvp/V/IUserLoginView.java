package com.example.xqm.examplemvp.V;


import com.example.xqm.examplemvp.M.User;

/**
 * 定义与用户交互的接口
 * Created by XQM on 2018/4/15.
 */

public interface IUserLoginView {
    String getUserName();
    String getUserPwd();
    void clearUserName();
    void clearPassword();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailedError();
}
