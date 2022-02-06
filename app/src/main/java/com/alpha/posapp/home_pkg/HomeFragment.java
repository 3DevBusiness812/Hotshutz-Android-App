package com.alpha.posapp.home_pkg;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.alpha.posapp.R;
import com.alpha.posapp.bean.HistoryData;
import com.alpha.posapp.cat_pkg.All_Category_Activity;
import com.alpha.posapp.product_pkg.Product_List_Activity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment implements View.OnClickListener, Home_Category_Adapter.MyOrderAppOnclickListener
,Home_Product_Adapter.MyOrderAppOnclickListener,Home_Vendor_Adapter.MyOrderAppOnclickListener{
    View v;
    public ArrayList<HistoryData> bannerList;
    public ArrayList<HistoryData> catList;
    public ArrayList<HistoryData> productList;
    public ArrayList<HistoryData> vendorList;

    private int currentPage = 0;
    private Timer timer;
    private long DELAY_MS = 500;
    private long PERIOD_MS = 5000;
    private ViewPager vpHomeFirstBanner;
    private TabLayout tlHomeFirstBanner;
    private Handler handler;
    RecyclerView rv_cat_pkg,rv_product,rv_ourtop_vendor;
    AppCompatTextView tv_seeall_product;
    AppCompatImageView iv_allcat;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_home, container, false);
        Init(v);

        getWeekendList();
        getCategoryList();
        getProductList();
        getVendoreList();

        return v;
    }

    private void Init(View view) {
        rv_cat_pkg = view.findViewById(R.id.rv_cat_pkg);
        rv_product = view.findViewById(R.id.rv_product);
        rv_ourtop_vendor = view.findViewById(R.id.rv_ourtop_vendor);
        iv_allcat = view.findViewById(R.id.iv_allcat);
        tv_seeall_product = view.findViewById(R.id.tv_seeall_product);

        vpHomeFirstBanner = view.findViewById(R.id.vpHomeFirstBannerId);
        tlHomeFirstBanner = view.findViewById(R.id.tlHomeFirstBannerId);

        productList = new ArrayList<>();
        catList = new ArrayList<>();
        bannerList = new ArrayList<>();
        vendorList = new ArrayList<>();

        iv_allcat.setOnClickListener(this);
        tv_seeall_product.setOnClickListener(this);

        rv_cat_pkg.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv_product.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv_ourtop_vendor.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }


    public void getWeekendList(){
        for(int i=0; i<4; i++){
            bannerList.add(new HistoryData("You have"));
        }
        FirstBannerAdapter firstBannerAdapter = new FirstBannerAdapter(getActivity(), bannerList);
        vpHomeFirstBanner.setAdapter(firstBannerAdapter);
        tlHomeFirstBanner.setupWithViewPager(vpHomeFirstBanner);
        scrooling(bannerList.size());
    }

    public void getVendoreList(){
        for(int i=0; i<8; i++){
            vendorList.add(new HistoryData("Cafe Coffee Day"));
        }
        Home_Vendor_Adapter adapter = new Home_Vendor_Adapter(getActivity(), vendorList,this);
        rv_ourtop_vendor.setAdapter(adapter);
    }

    public void getProductList(){
        for(int i=0; i<8; i++){
            productList.add(new HistoryData("Kiwi- 500gm"));
        }
        Home_Product_Adapter adapter = new Home_Product_Adapter(getActivity(), productList,this);
        rv_product.setAdapter(adapter);
    }

    public void getCategoryList(){
        for(int i=0; i<8; i++){
            catList.add(new HistoryData("Beverage"));
        }
        Home_Category_Adapter adapter = new Home_Category_Adapter(getActivity(), catList,this);
        rv_cat_pkg.setAdapter(adapter);
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
        if (v.getId() == R.id.iv_allcat) {
            startActivity(new Intent(getContext(), All_Category_Activity.class));
        }
//
        if (v.getId() == R.id.tv_seeall_product) {
            startActivity(new Intent(getContext(), Product_List_Activity.class));
        }

    }


    @Override
    public void MyOrderAppOnclickListener(View view, int position, HistoryData orderList) {

    }
}
