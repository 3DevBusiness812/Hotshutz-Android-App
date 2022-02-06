package com.alpha.posapp.authenticationModule;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.alpha.posapp.R;
import com.alpha.posapp.utility.CheckNetwork;


public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       try {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                        CheckNetwork.nextScreenWithFinish(Splash_Activity.this, Login_Activity.class);
                }
            }, 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
