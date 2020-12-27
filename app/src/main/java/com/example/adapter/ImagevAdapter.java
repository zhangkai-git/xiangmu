package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.bean.ShowBean;
import com.example.xiangmu.R;

import java.util.ArrayList;

public class ImagevAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<ShowBean.DataBean.BrandListBean> brandlist;
    private GridLayoutHelper gridLayoutHelper;

    public ImagevAdapter(Context context, ArrayList<ShowBean.DataBean.BrandListBean> brandlist, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.brandlist = brandlist;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_brand, parent, false);
        return new BrandVH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShowBean.DataBean.BrandListBean brandListBean = brandlist.get(position);
        BrandVH brandVH = (BrandVH) holder;
        brandVH.name.setText(brandListBean.getName());
        brandVH.title.setText(brandListBean.getFloor_price() + "元起");
        Glide.with(context).load(brandListBean.getNew_pic_url()).into(brandVH.image);
    }

    @Override
    public int getItemCount() {
        return brandlist.size();
    }

    private class BrandVH extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView title;

        public BrandVH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.brand_image);
            name = itemView.findViewById(R.id.brand_name);
            title = itemView.findViewById(R.id.brand_title);
        }
    }
}
