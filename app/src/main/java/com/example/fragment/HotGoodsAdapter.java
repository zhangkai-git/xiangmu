package com.example.fragment;

import android.content.Context;
import android.media.Image;
import android.os.HardwarePropertiesManager;
import android.provider.ContactsContract;
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
import com.google.android.material.resources.TextAppearanceConfig;

import java.util.ArrayList;

public class HotGoodsAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<ShowBean.DataBean.HotGoodsListBean> hotgoodslist;
    private GridLayoutHelper gridLayoutHelper;

    public HotGoodsAdapter(Context context, ArrayList<ShowBean.DataBean.HotGoodsListBean> hotgoodslist, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.hotgoodslist = hotgoodslist;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_hotgoods, parent, false);
        return new HotGoodsVH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShowBean.DataBean.HotGoodsListBean hotGoodsListBean = hotgoodslist.get(position);
        HotGoodsVH vh = (HotGoodsVH) holder;
        vh.name.setText(hotGoodsListBean.getName());
        vh.price.setText("$"+hotGoodsListBean.getRetail_price());
        Glide.with(context).load(hotGoodsListBean.getList_pic_url()).into(vh.image);
    }

    @Override
    public int getItemCount() {
        return hotgoodslist.size();
    }

    private class HotGoodsVH extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView price;

        public HotGoodsVH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.hotgoods_image);
            name = itemView.findViewById(R.id.hotgoods_name);
            price = itemView.findViewById(R.id.hotgoods_price);
        }
    }
}
