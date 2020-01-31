package com.t3h.perfecthostel.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    public static final String TAG = LoginActivity.class.getSimpleName();

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
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
        final String userName = binding.username.getText().toString().trim();
        String password = binding.pasword.getText().toString().trim();

        if (userName.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, R.string.not_empty_field, Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    Log.e(TAG, "onComplete: ", task.getException() );
                    Toast.makeText(LoginActivity.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClickedRegister() {
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, Const.REQUEST_REGISTER);
    }

    @Override
    public void onForgotPass() {

    }

    private void showFullyCustomToast() {
       //  Get the custom layout view.

//        View toastView = getLayoutInflater().inflate(R.layout.support_simple_spinner_dropdown_item, null);
//        ImageView im = toastView.findViewById(R.id.customToastImage);
//        Glide.with(im)
//                .load(R.drawable.ic_cancel)
//                .into(im);
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
