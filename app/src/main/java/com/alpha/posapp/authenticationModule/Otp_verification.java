package com.alpha.posapp.authenticationModule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import com.alpha.posapp.HomeActivity;
import com.alpha.posapp.MainActivity;
import com.alpha.posapp.R;
import com.alpha.posapp.utility.CheckNetwork;


public class Otp_verification extends AppCompatActivity implements View.OnClickListener {
    private AppCompatImageView ivBackForgetId;
    private LinearLayout liresendotpMainId,lieditNumberid;
    private AppCompatButton btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_otp);

        ivBackForgetId = findViewById(R.id.ivBackForgetId);
         liresendotpMainId = findViewById(R.id.liresendotpMainId);
        lieditNumberid = findViewById(R.id.lieditNumberid);
        btn_send = findViewById(R.id.btn_send);
        ivBackForgetId.setOnClickListener(this);
        liresendotpMainId.setOnClickListener(this);
        lieditNumberid.setOnClickListener(this);
        btn_send.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBackForgetId:
                CheckNetwork.backScreenWithFinis(Otp_verification.this);
                break;
            case R.id.lieditNumberid:
                CheckNetwork.backScreenWithFinis(Otp_verification.this);
                break;
            case R.id.liresendotpMainId:
//                Toast.makeText(this, "working..", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_send:
                startActivity(new Intent(Otp_verification.this, HomeActivity.class));
//                finishAffinity();
                break;
        }
    }
}
