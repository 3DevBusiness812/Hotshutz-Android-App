package com.alpha.posapp.cart_pkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.posapp.payment_pkg.PayNow_Activity;
import com.alpha.posapp.R;
import com.alpha.posapp.bean.HistoryData;
import com.alpha.posapp.notification_pkg.Notification_Activity;

import java.util.ArrayList;

public class AddToCart_Activity extends AppCompatActivity implements View.OnClickListener, AddToCart_Adapter.MyOrderAppOnclickListener {
    public ArrayList<HistoryData> chatList;
    RecyclerView chat_rv;
    ImageView iv_back;
    View toolbar;
    AppCompatTextView tv_title;
    RelativeLayout rl_cat,rl_search,rl_notification;
    AppCompatButton btn_checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        toolbar = findViewById(R.id.toolbar);
        tv_title = toolbar.findViewById(R.id.tv_tittle);
        rl_cat = toolbar.findViewById(R.id.rl_cat);
        rl_search = toolbar.findViewById(R.id.rl_search);
        rl_notification = toolbar.findViewById(R.id.rl_notification);
        iv_back = toolbar.findViewById(R.id.id_back);

        iv_back.setOnClickListener(this);
        rl_notification.setOnClickListener(this);
        rl_cat.setOnClickListener(this);

        tv_title.setText(R.string.addtocart);
        chat_rv = findViewById(R.id.rv_addtocart);
        btn_checkout = findViewById(R.id.btn_checkout);

        chatList = new ArrayList<>();
        btn_checkout.setOnClickListener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        chat_rv.setLayoutManager(linearLayoutManager);

        getVendoreList();
    }


    public void getVendoreList(){
        for(int i=0; i<2; i++){
            chatList.add(new HistoryData("John Deo"));
        }

        AddToCart_Adapter adapter = new AddToCart_Adapter(getApplicationContext(), chatList,this);
        chat_rv.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.id_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

            case R.id.btn_checkout:
             startActivity(new Intent(AddToCart_Activity.this, PayNow_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;


            case R.id.rl_cat:
                startActivity(new Intent(AddToCart_Activity.this, AddToCart_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

            case R.id.rl_notification:
                startActivity(new Intent(AddToCart_Activity.this, Notification_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

        }
    }

    @Override
    public void MyOrderAppOnclickListener(View view, int position, HistoryData orderList) {

    }
}
