package com.alpha.posapp.payment_history_pkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.posapp.R;
import com.alpha.posapp.bean.HistoryData;
import com.alpha.posapp.cart_pkg.AddToCart_Activity;
import com.alpha.posapp.chat_pkg.Chat_Adapter;
import com.alpha.posapp.notification_pkg.Notification_Activity;

import java.util.ArrayList;

public class PaymentHistoryDetail_Activity extends AppCompatActivity implements View.OnClickListener, Chat_Adapter.MyOrderAppOnclickListener {
    public ArrayList<HistoryData> chatList;
    RecyclerView chat_rv;
    ImageView iv_back;
    View toolbar;
    AppCompatTextView tv_title, tv_notification,tv_clearNotification;
    AppCompatImageView iv_notification;
    String userid;
    RelativeLayout rl_cat,rl_search,rl_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_history_detail);
//        userid = AppSession.getStringPreferences(Notification_Activity.this, Constants.USER_ID);

        toolbar = findViewById(R.id.toolbar);
        tv_title = toolbar.findViewById(R.id.tv_tittle);
        rl_cat = toolbar.findViewById(R.id.rl_cat);
        rl_search = toolbar.findViewById(R.id.rl_search);
        rl_notification = toolbar.findViewById(R.id.rl_notification);
        iv_back = toolbar.findViewById(R.id.id_back);

        iv_back.setOnClickListener(this);
        rl_notification.setOnClickListener(this);
        rl_cat.setOnClickListener(this);

        tv_title.setText(R.string.details);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.id_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

            case R.id.rl_cat:
                startActivity(new Intent(PaymentHistoryDetail_Activity.this, AddToCart_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

            case R.id.rl_notification:
                startActivity(new Intent(PaymentHistoryDetail_Activity.this, Notification_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
        }
    }

    @Override
    public void MyOrderAppOnclickListener(View view, int position, HistoryData orderList) {

    }
}
