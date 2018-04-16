package com.example.xqm.examplemvp.P;

import android.app.Activity;
import android.os.Handler;

import com.example.xqm.examplemvp.M.IUserBiz;
import com.example.xqm.examplemvp.M.OnLoginListener;
import com.example.xqm.examplemvp.M.User;
import com.example.xqm.examplemvp.M.UserBiz;
import com.example.xqm.examplemvp.V.IUserLoginView;

import java.lang.ref.WeakReference;

/**
 * Created by XQM on 2018/4/15.
 */

public class UserLoginPresenter {
    private IUserLoginView iUserLoginView;
    private IUserBiz iUserBiz;

    private MyHandler mHandler;

    public UserLoginPresenter(IUserLoginView iUserLoginView){
        this.iUserLoginView = iUserLoginView;
        iUserBiz = new UserBiz();
        mHandler = new MyHandler();
    }

    /**
     * 登陆逻辑
     */
    public void login(){
        iUserLoginView.showLoading();

        iUserBiz.login(iUserLoginView.getUserName(), iUserLoginView.getUserPwd(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.toMainActivity(user);
                        iUserLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.showFailedError();
                        iUserLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
       iUserLoginView.clearUserName();
       iUserLoginView.clearPassword();
    }

    private static class MyHandler extends Handler {
        WeakReference<Activity> mActivityReference;
        MyHandler(){

        }
        MyHandler(Activity activity){
            mActivityReference= new WeakReference<Activity>(activity);
        }
    }

}


