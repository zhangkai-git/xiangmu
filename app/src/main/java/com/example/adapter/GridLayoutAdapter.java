package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bean.ShowBean;
import com.example.xiangmu.R;

import java.util.ArrayList;

public class GridLayoutAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ShowBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans;

    public GridLayoutAdapter(Context context, ArrayList<ShowBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans) {
        this.context = context;
        this.goodsListBeans = goodsListBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_goods, parent, false);
        return new VH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShowBean.DataBean.CategoryListBean.GoodsListBean goodsListBean = goodsListBeans.get(position);
        VH vh = (VH) holder;
        vh.name.setText(goodsListBean.getName());
        vh.price.setText("$" + goodsListBean.getRetail_price());
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(vh.image);
    }

    @Override
    public int getItemCount() {
        return goodsListBeans.size();
    }

    class VH extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView price;

        public VH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.cate_image);
            name = itemView.findViewById(R.id.cate_name);
            price = itemView.findViewById(R.id.cate_price);
        }
    }
}