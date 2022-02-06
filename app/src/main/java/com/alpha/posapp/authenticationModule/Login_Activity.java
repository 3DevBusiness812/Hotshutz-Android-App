package com.alpha.posapp.authenticationModule;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.alpha.posapp.R;
import com.alpha.posapp.utility.CheckNetwork;


public class Login_Activity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatTextView tvRegisteredNow;
    AppCompatButton btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_login);

        tvRegisteredNow = findViewById(R.id.tvSignUpId);
        btn_login = findViewById(R.id.btn_login);

        tvRegisteredNow.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.tvForgetPasswordId:
//                CheckNetwork.nextScreenWithoutFinish(Login_Activity.this, Forget_Activity.class);
//                break;
           case R.id.btn_login:
               //startActivity(new Intent(Login_Activity.this, HomeActivity.class));
              // finish();
               // validation(v);
               CheckNetwork.nextScreenWithoutFinish(Login_Activity.this, Otp_verification.class);
                break;
            case R.id.tvSignUpId:
                CheckNetwork.nextScreenWithoutFinish(Login_Activity.this, SignUp_Activity.class);
                break;

        }
    }
}
