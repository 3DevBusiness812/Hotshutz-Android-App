package com.alpha.posapp.product_pkg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.PagerAdapter;

import com.alpha.posapp.R;
import com.alpha.posapp.bean.HistoryData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;


public class ProductImageBannerAdapter extends PagerAdapter {
    private Context mContext;
    private List<HistoryData> datumList;

    public ProductImageBannerAdapter(Context context, List<HistoryData> datumList) {
        mContext = context;
        this.datumList = datumList;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.product_detail_banner_adapter, collection, false);
        AppCompatImageView ivSlideId = layout.findViewById(R.id.ivSlideId);
       /// Picasso.with(mContext).load(RetrofitClient.BANNER_URL + datumList.get(position).getSliderImage()).into(ivSlideId);

        Glide.with(mContext)
                .load(R.drawable.myorder_img)
                .placeholder(R.drawable.myorder_img)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontTransform()
                .into(ivSlideId);

        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }
    public void addBanner(List<HistoryData> datumList) {
        this.datumList = datumList;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        //  return 3;
        return datumList == null ? 0 : datumList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

 /*   @Override
    public CharSequence getPageTitle(int position) {
        return slangList.get(position);
    }
*/
}