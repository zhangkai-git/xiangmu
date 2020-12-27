package com.example.adapter;

import android.content.Context;
import android.media.Image;
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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.bean.ShowBean;
import com.example.xiangmu.R;

import java.util.ArrayList;

public class NewGoodsAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<ShowBean.DataBean.NewGoodsListBean> newgoodslist;
    private GridLayoutHelper gridLayoutHelper;

    public NewGoodsAdapter(Context context, ArrayList<ShowBean.DataBean.NewGoodsListBean> newgoodslist, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.newgoodslist = newgoodslist;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_newgoods, parent, false);
        return new NewGoodsVH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShowBean.DataBean.NewGoodsListBean newGoodsListBean = newgoodslist.get(position);
        NewGoodsVH vh = (NewGoodsVH) holder;
        vh.name.setText(newGoodsListBean.getName());
        vh.price.setText("$"+newGoodsListBean.getRetail_price());
        Glide.with(context).load(newGoodsListBean.getList_pic_url()).into(vh.image);
    }

    @Override
    public int getItemCount() {
        return newgoodslist.size();
    }

    private class NewGoodsVH extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView price;

        public NewGoodsVH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.newgoods_image);
            name = itemView.findViewById(R.id.newgoods_name);
            price = itemView.findViewById(R.id.newgoods_price);
        }
    }
}
