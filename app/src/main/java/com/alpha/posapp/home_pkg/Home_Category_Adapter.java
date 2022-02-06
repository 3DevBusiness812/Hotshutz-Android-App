package com.alpha.posapp.home_pkg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;


import com.alpha.posapp.R;
import com.alpha.posapp.bean.HistoryData;

import java.util.ArrayList;

public class Home_Category_Adapter extends RecyclerView.Adapter<Home_Category_Adapter.MyViewHolder> {
        public ArrayList<HistoryData> searchList;
        Context context;
        private LayoutInflater mInflater;
        private MyOrderAppOnclickListener myOrderAppOnclickListener;


        public Home_Category_Adapter(Context activity, ArrayList<HistoryData> List, MyOrderAppOnclickListener myOrderAppOnclickListener) {
            searchList = List;
            context = activity;
            this.myOrderAppOnclickListener = myOrderAppOnclickListener;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
            AppCompatTextView name_tv;
            LinearLayout ll_box;

            public MyViewHolder(View view) {
                super(view);
                name_tv = view.findViewById(R.id.tv_productname);
//                ll_box = view.findViewById(R.id.ll_box);
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
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_row, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            final HistoryData detail = searchList.get(position);

            holder.name_tv.setText(detail.getOrdername());

        }


    public interface MyOrderAppOnclickListener {
        void MyOrderAppOnclickListener(View view, int position, HistoryData orderList);
    }


        @Override
        public int getItemCount() {
            return searchList.size();
        }
    }