package com.t3h.perfecthostel.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.t3h.perfecthostel.Const;
import com.t3h.perfecthostel.MainActivity;
import com.t3h.perfecthostel.R;
import com.t3h.perfecthostel.activity.register.RegisterActivity;
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
        final String userName = binding.username.getText().toString();
        String password = binding.pasword.getText().toString();

        mAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                } else {
                    Toast.makeText(LoginActivity.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        
    }

    @Override
    public void onClickedRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, Const.REQUEST_REGISTER);
    }

    @Override
    public void onForgotPass() {

    }

}
