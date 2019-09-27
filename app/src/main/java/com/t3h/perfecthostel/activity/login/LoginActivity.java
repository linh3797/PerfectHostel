package com.t3h.perfecthostel.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
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

        if (userName.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Không được để trống các trường!", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
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

    private void showFullyCustomToast() {
        // Get the custom layout view.

//        View toastView = getLayoutInflater().inflate(R.layout.activity_toast_custom_view, null);
////        ImageView im = toastView.findViewById(R.id.customToastImage);
////        Glide.with(im)
////                .load(R.drawable.ic_cancel)
////                .into(im);
//        TextView tv = toastView.findViewById(R.id.customToastText);
//        tv.setText(getResources().getString(R.string.toast_null));
//        // Initiate the Toast instance.
//        Toast toast = new Toast(getApplicationContext());
//        // Set custom view in toast.
//        toast.setView(toastView);
//        toast.setDuration(Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.BOTTOM, 0, 120);
//        toast.show();
    }

}
