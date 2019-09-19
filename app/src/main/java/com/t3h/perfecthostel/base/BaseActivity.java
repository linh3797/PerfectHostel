package com.t3h.perfecthostel.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Created by Linh Nguyen Thuy on 9/19/2019.
 */
public abstract class BaseActivity <DB extends ViewDataBinding> extends AppCompatActivity {
    protected DB binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();
}
