package com.alpha.posapp.authenticationModule;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.alpha.posapp.R;
import com.alpha.posapp.utility.CheckNetwork;


public class SignUp_Activity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatImageView ivBackForgetId;
    private AppCompatTextView tv_login;
    AppCompatButton btn_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_signup);

        btn_otp = findViewById(R.id.btn_otp);
        tv_login = findViewById(R.id.tv_login);
        ivBackForgetId = findViewById(R.id.iv_back);


        btn_otp.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        ivBackForgetId.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                CheckNetwork.backScreenWithFinis(SignUp_Activity.this);
                break;
            case R.id.btn_otp:
                CheckNetwork.nextScreenWithoutFinish(SignUp_Activity.this, Otp_verification.class);
                break;
            case R.id.tv_login:
                CheckNetwork.nextScreenWithoutFinish(SignUp_Activity.this, Login_Activity.class);
                break;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
