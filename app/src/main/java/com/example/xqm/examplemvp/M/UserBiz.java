package com.example.xqm.examplemvp.M;

/**
 * Created by XQM on 2018/4/15.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String userName, final String userPwd, final OnLoginListener onLoginListener) {
        //模拟登陆
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if ("deng".equals(userName) && "0000".equals(userPwd)){
                    User user = new User();
                    user.setUserName(userName);
                    user.setUserPwd(userPwd);
                    onLoginListener.loginSuccess(user);
                }else {
                    onLoginListener.loginFailed();
                }
            }
        }.start();
    }
}
