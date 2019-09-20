package com.t3h.perfecthostel.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Linh Nguyen Thuy on 9/19/2019.
 */
public abstract class BaseActivity <DB extends ViewDataBinding> extends AppCompatActivity {
    protected DB binding;
    protected FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        mAuth = FirebaseAuth.getInstance();
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();
}
