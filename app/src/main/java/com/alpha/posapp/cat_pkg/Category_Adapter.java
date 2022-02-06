package com.alpha.posapp.cat_pkg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.posapp.R;
import com.alpha.posapp.bean.HistoryData;

import java.util.ArrayList;

public class Category_Adapter extends RecyclerView.Adapter<Category_Adapter.MyViewHolder> {
        public ArrayList<HistoryData> searchList;
        Context context;
        private LayoutInflater mInflater;
        private MyOrderAppOnclickListener myOrderAppOnclickListener;


        public Category_Adapter(Context activity, ArrayList<HistoryData> List, MyOrderAppOnclickListener myOrderAppOnclickListener) {
            searchList = List;
            context = activity;
            this.myOrderAppOnclickListener = myOrderAppOnclickListener;
        }



    public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
            AppCompatTextView name_tv;
            LinearLayout ll_box;

            public MyViewHolder(View view) {
                super(view);
//                name_tv = view.findViewById(R.id.tv_title);
                ll_box = view.findViewById(R.id.ll_catbox);
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
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_category_row, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
            final HistoryData detail = searchList.get(position);

//            holder.name_tv.setText(detail.getOrdername());


            holder.ll_box.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.ll_box.setBackground(context.getResources().getDrawable(R.drawable.category_outline_green_shape));
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