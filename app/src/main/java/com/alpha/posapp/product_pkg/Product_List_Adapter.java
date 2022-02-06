package com.alpha.posapp.product_pkg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.posapp.R;
import com.alpha.posapp.bean.HistoryData;
import com.alpha.posapp.payment_history_pkg.PaymentHistoryDetail_Activity;

import java.util.ArrayList;

public class Product_List_Adapter extends RecyclerView.Adapter<Product_List_Adapter.MyViewHolder> {
        public ArrayList<HistoryData> searchList;
        Context context;
        private LayoutInflater mInflater;
        private MyOrderAppOnclickListener myOrderAppOnclickListener;



        public Product_List_Adapter(Context activity, ArrayList<HistoryData> List, MyOrderAppOnclickListener myOrderAppOnclickListener) {
            searchList = List;
            context = activity;
            this.myOrderAppOnclickListener = myOrderAppOnclickListener;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
            AppCompatButton btn_viewdetail;
            LinearLayout ll_view_detail;

            public MyViewHolder(View view) {
                super(view);
                btn_viewdetail = view.findViewById(R.id.btn_viewdetail);
                ll_view_detail = view.findViewById(R.id.ll_view_detail);

            }

            @Override
            public void onClick(View v) {
                myOrderAppOnclickListener.MyOrderAppOnclickListener(v, getAdapterPosition(), searchList.get(getAdapterPosition()));
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            final HistoryData detail = searchList.get(position);

//            holder.name_tv.setText(detail.getOrdername());

            holder.ll_view_detail.setOnClickListener(new View.OnClickListener() {
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