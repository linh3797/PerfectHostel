package com.t3h.perfecthostel.activity.register;

import com.t3h.perfecthostel.R;
import com.t3h.perfecthostel.base.BaseActivity;
import com.t3h.perfecthostel.databinding.ActivityRegisterBinding;

/**
 * Created by Linh Nguyen Thuy on 9/20/2019.
 */
public class RegisterActivity extends BaseActivity<ActivityRegisterBinding> implements RegisterListener {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        binding.setListener(this);
    }

    @Override
    public void onClickedRegister() {

    }

    @Override
    public void onClickedExit() {

    }
}
