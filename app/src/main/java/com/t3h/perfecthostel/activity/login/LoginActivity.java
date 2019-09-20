package com.t3h.perfecthostel.activity.login;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.t3h.perfecthostel.R;
import com.t3h.perfecthostel.base.BaseActivity;
import com.t3h.perfecthostel.databinding.ActivityLoginBinding;

/**
 * Created by Linh Nguyen Thuy on 9/19/2019.
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements LoginListener {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        binding.setListener(this);
    }

    @Override
    public void onClickedLogin() {

    }

    @Override
    public void onClickedRegister() {

    }

    @Override
    public void onForgotPass() {

    }
}
