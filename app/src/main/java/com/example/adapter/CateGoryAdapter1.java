package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
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
import java.util.List;

public class CateGoryAdapter1 extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<ShowBean.DataBean.CategoryListBean.GoodsListBean> categoryListBeans;
    private GridLayoutHelper gridLayoutHelper;

    public CateGoryAdapter1(Context context, ArrayList<ShowBean.DataBean.CategoryListBean.GoodsListBean> categoryListBeans, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.categoryListBeans = categoryListBeans;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new CateVH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShowBean.DataBean.CategoryListBean.GoodsListBean goodsListBean = categoryListBeans.get(position);
        CateVH vh = (CateVH) holder;
        vh.name.setText(goodsListBean.getName());
        vh.price.setText("$" + goodsListBean.getRetail_price());
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(vh.image);
    }

    @Override
    public int getItemCount() {
        return categoryListBeans.size();
    }

    private class CateVH extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView price;

        public CateVH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.cate_image);
            name = itemView.findViewById(R.id.cate_name);
            price = itemView.findViewById(R.id.cate_price);
        }
    }
}
