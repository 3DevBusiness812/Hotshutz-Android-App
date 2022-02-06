package com.alpha.posapp.profile_pkg;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.alpha.posapp.home_pkg.Home_Category_Adapter;
import com.alpha.posapp.home_pkg.Home_Product_Adapter;
import com.alpha.posapp.home_pkg.Home_Vendor_Adapter;
import com.alpha.posapp.R;
import com.alpha.posapp.address_pkg.EditAddress_Activity;
import com.alpha.posapp.bean.HistoryData;
import com.alpha.posapp.chat_pkg.Chat_Activity;

public class ProfileFragment extends Fragment implements View.OnClickListener, Home_Category_Adapter.MyOrderAppOnclickListener
,Home_Product_Adapter.MyOrderAppOnclickListener,Home_Vendor_Adapter.MyOrderAppOnclickListener{
    View v;
    AppCompatTextView iv_editprofile;
    LinearLayout ll_editaddress,ll_chat;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.profile_home, container, false);
        Init(v);



        return v;
    }

    private void Init(View view) {
        iv_editprofile = view.findViewById(R.id.iv_editprofile);
        ll_editaddress = view.findViewById(R.id.ll_editaddress);
        ll_chat = view.findViewById(R.id.ll_chat);

        iv_editprofile.setOnClickListener(this);
        ll_editaddress.setOnClickListener(this);
        ll_chat.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_editprofile) {
            startActivity(new Intent(getContext(),EditProfile_Activity.class));
        }

        if (v.getId() == R.id.ll_editaddress) {
            startActivity(new Intent(getContext(), EditAddress_Activity.class));
        }

        if (v.getId() == R.id.ll_chat) {
            startActivity(new Intent(getContext(), Chat_Activity.class));
        }
//
//
//
//        if (v.getId() == R.id.logout_layout) { }

    }


    @Override
    public void MyOrderAppOnclickListener(View view, int position, HistoryData orderList) {

    }
}
