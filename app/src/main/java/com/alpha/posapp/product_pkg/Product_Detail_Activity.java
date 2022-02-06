package com.alpha.posapp.product_pkg;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.alpha.posapp.R;
import com.alpha.posapp.bean.HistoryData;
import com.alpha.posapp.notification_pkg.Notification_Adapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Product_Detail_Activity extends AppCompatActivity implements View.OnClickListener, Notification_Adapter.MyOrderAppOnclickListener {
    public ArrayList<HistoryData> bannerList;
    RecyclerView chat_rv;
    ImageView iv_back;
    View toolbar;
    AppCompatTextView tv_title, tv_notification,tv_clearNotification;
    AppCompatImageView iv_notification;
    String userid;
    RelativeLayout rl_cat,rl_search,rl_notification;
    private int currentPage = 0;
    private Timer timer;
    private long DELAY_MS = 500;
    private long PERIOD_MS = 5000;
    private ViewPager vpHomeFirstBanner;
    private TabLayout tlHomeFirstBanner;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);
//        userid = AppSession.getStringPreferences(Notification_Activity.this, Constants.USER_ID);

        toolbar = findViewById(R.id.toolbar);
        tv_title = toolbar.findViewById(R.id.tv_tittle);
        rl_cat = toolbar.findViewById(R.id.rl_cat);
        rl_search = toolbar.findViewById(R.id.rl_search);
        rl_notification = toolbar.findViewById(R.id.rl_notification);
        iv_back = toolbar.findViewById(R.id.id_back);

        vpHomeFirstBanner = findViewById(R.id.vpHomeFirstBannerId);
        tlHomeFirstBanner = findViewById(R.id.tlHomeFirstBannerId);

        iv_back.setOnClickListener(this);

        tv_title.setText(R.string.productdetail);

        bannerList = new ArrayList<>();

        getWeekendList();
    }


    public void getWeekendList(){
        for(int i=0; i<3; i++){
            bannerList.add(new HistoryData("You have"));
        }
        ProductImageBannerAdapter firstBannerAdapter = new ProductImageBannerAdapter(Product_Detail_Activity.this, bannerList);
        vpHomeFirstBanner.setAdapter(firstBannerAdapter);
        tlHomeFirstBanner.setupWithViewPager(vpHomeFirstBanner);
//        scrooling(bannerList.size());
    }

    private void scrooling(final int length) {
        handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (currentPage == length) {
                    currentPage = 0;
                }
                vpHomeFirstBanner.setCurrentItem(currentPage++, true);
            }
        };

        TimerTask timertask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        handler.post(runnable);
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(timertask, DELAY_MS, PERIOD_MS);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.id_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
        }
    }

    @Override
    public void MyOrderAppOnclickListener(View view, int position, HistoryData orderList) {

    }
}
