package com.t3h.perfecthostel.activity.register;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.t3h.perfecthostel.R;
import com.t3h.perfecthostel.activity.login.LoginActivity;
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

    public static final String TAG = RegisterActivity.class.getSimpleName();
    @Override
    protected void initView() {
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
        binding.setListener(this);
    }

    @Override
    public void onClickedRegister() {
        String userName = binding.username.getText().toString().trim();
        String password = binding.pasword.getText().toString().trim();
        String confirmPassword = binding.confirmPassword.getText().toString();

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Password nhập lại không đúng!", Toast.LENGTH_SHORT).show();
            binding.confirmPassword.setText("");
            return;
        } else {
            mAuth.createUserWithEmailAndPassword(userName, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Đăng kí thành công!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        finish();
                    }
                }
            });
        }
    }

    @Override
    public void onClickedExit() {
        finish();
    }
}
