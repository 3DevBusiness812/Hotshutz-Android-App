package com.alpha.posapp.home_pkg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.posapp.R;
import com.alpha.posapp.bean.HistoryData;
import com.alpha.posapp.cart_pkg.AddToCart_Activity;
import com.alpha.posapp.product_pkg.Product_Detail_Activity;

import java.util.ArrayList;

public class Home_Product_Adapter extends RecyclerView.Adapter<Home_Product_Adapter.MyViewHolder> {
        public ArrayList<HistoryData> searchList;
        Context context;
        private LayoutInflater mInflater;
        private MyOrderAppOnclickListener myOrderAppOnclickListener;


        public Home_Product_Adapter(Context activity, ArrayList<HistoryData> List, MyOrderAppOnclickListener myOrderAppOnclickListener) {
            searchList = List;
            context = activity;
            this.myOrderAppOnclickListener = myOrderAppOnclickListener;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
            AppCompatTextView name_tv;
            AppCompatButton btn_addtocart;
            LinearLayout ll_wholebox;

            public MyViewHolder(View view) {
                super(view);
                name_tv = view.findViewById(R.id.tv_title);
                btn_addtocart = view.findViewById(R.id.btn_addtocart);
                ll_wholebox = view.findViewById(R.id.ll_wholebox);
//
//                ll_box.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                myOrderAppOnclickListener.MyOrderAppOnclickListener(v, getAdapterPosition(), searchList.get(getAdapterPosition()));
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_product_item, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            final HistoryData detail = searchList.get(position);

            holder.name_tv.setText(detail.getOrdername());

            holder.btn_addtocart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, AddToCart_Activity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            });

            holder.ll_wholebox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, Product_Detail_Activity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            });

        }


    public interface MyOrderAppOnclickListener {
        void MyOrderAppOnclickListener(View view, int position, HistoryData orderList);
    }


        @Override
        public int getItemCount() {
            return searchList.size();
        }
    }