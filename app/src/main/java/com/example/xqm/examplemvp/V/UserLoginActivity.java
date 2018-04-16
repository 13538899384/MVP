package com.example.xqm.examplemvp.V;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xqm.examplemvp.M.User;
import com.example.xqm.examplemvp.MainActivity;
import com.example.xqm.examplemvp.P.UserLoginPresenter;
import com.example.xqm.examplemvp.R;
import com.example.xqm.examplemvp.utils.DialogLoadingUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 实现与用户交互的接口
 * Created by XQM on 2018/4/15.
 */

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {
    @Bind(R.id.edt_pwd)
    EditText edtPwd;
    @Bind(R.id.edt_userName)
    EditText edtUserName;
    private Dialog mDialog = null;
    private UserLoginPresenter mUserLoginPresenter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mUserLoginPresenter = new UserLoginPresenter(this);
    }

    @Override
    public String getUserName() {
        return edtUserName.getText().toString().trim();
    }

    @Override
    public String getUserPwd() {
        return edtPwd.getText().toString().trim();
    }

    @Override
    public void clearUserName() {
        edtUserName.setText("");
    }

    @Override
    public void clearPassword() {
        edtPwd.setText("");
    }

    @Override
    public void showLoading() {
        mDialog = DialogLoadingUtils.createLoadingDialog(this,"正在登陆");
    }

    @Override
    public void hideLoading() {
        DialogLoadingUtils.closeDialog(mDialog);
        mDialog.dismiss();
    }

    @Override
    public void toMainActivity(User user) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showFailedError() {
        hideLoading();
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        mUserLoginPresenter.login();
    }
}
