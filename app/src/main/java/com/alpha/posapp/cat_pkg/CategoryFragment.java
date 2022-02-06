package com.alpha.posapp.cat_pkg;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.posapp.R;
import com.alpha.posapp.bean.HistoryData;
import com.alpha.posapp.myorder_pkg.My_Order_Adapter;

import java.util.ArrayList;

public class CategoryFragment extends Fragment implements View.OnClickListener, Category_Adapter.MyOrderAppOnclickListener{
    View v;
    RecyclerView rv_cat_pkg;
    public ArrayList<HistoryData> productList;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_category, container, false);
        Init(v);

        getProductList();
        rv_cat_pkg.setLayoutManager(new GridLayoutManager(getContext(),3));
        return v;
    }

    private void Init(View view) {
        productList = new ArrayList<>();

        rv_cat_pkg = view.findViewById(R.id.rv_cat_pkg);
    }

    public void getProductList(){
        for(int i=0; i<8; i++){
            productList.add(new HistoryData("Kiwi- 500gm"));
        }
        Category_Adapter adapter = new Category_Adapter(getActivity(), productList,this);
        rv_cat_pkg.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
//        if (v.getId() == R.id.iv_editprofile) {
//            startActivity(new Intent(getContext(),EditProfile_Activity.class));
//        }
//
//        if (v.getId() == R.id.logout_layout) { }

    }


    @Override
    public void MyOrderAppOnclickListener(View view, int position, HistoryData orderList) {

    }
}
