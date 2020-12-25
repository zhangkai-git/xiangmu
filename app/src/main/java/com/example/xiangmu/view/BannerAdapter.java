package com.example.xiangmu.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.mvplibrary.utils.net.RetrofitUtils;
import com.example.xiangmu.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.view.BannerViewPager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ShowBean.DataBean.BannerBean> bannerlist;

    public BannerAdapter(Context context, ArrayList<ShowBean.DataBean.BannerBean> bannerlist) {
        this.context = context;
        this.bannerlist = bannerlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShowBean.DataBean.BannerBean bean = bannerlist.get(position);
        ViewHolder viewHolder = holder;
        viewHolder.banner.setImages(bannerlist).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ShowBean.DataBean.BannerBean bannerBean = (ShowBean.DataBean.BannerBean) path;
                Glide.with(context).load(bannerBean.getImage_url()).into(imageView);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return bannerlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Banner banner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }
}
