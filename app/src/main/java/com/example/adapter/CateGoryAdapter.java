package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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

public class CateGoryAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper;
    private GridLayoutHelper gridLayoutHelper;
    private DelegateAdapter delegateAdapter;
    private int _pos;
    private ArrayList<ShowBean.DataBean.CategoryListBean> categoryListBeans;
    private GridLayoutAdapter adapter;

    public CateGoryAdapter(Context context, LinearLayoutHelper linearLayoutHelper, ArrayList<ShowBean.DataBean.CategoryListBean> categoryListBeans) {
        this.context = context;
        this.linearLayoutHelper = linearLayoutHelper;
        this.categoryListBeans = categoryListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new CateVH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CateVH vh = (CateVH) holder;
        ShowBean.DataBean.CategoryListBean categoryListBean = categoryListBeans.get(position);
        vh.name.setText(categoryListBean.getName());

        ArrayList<ShowBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans = new ArrayList<>();
        List<ShowBean.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryListBean.getGoodsList();
        goodsListBeans.addAll(goodsList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        vh.recycler.setLayoutManager(gridLayoutManager);
        adapter = new GridLayoutAdapter(context, goodsListBeans);
        vh.recycler.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        if (categoryListBeans.size() > 0) {
            return categoryListBeans.size();
        } else {
            return 0;
        }
    }

    private class CateVH extends RecyclerView.ViewHolder {
        RecyclerView recycler;
        TextView name;

        public CateVH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name_tv_name);
            recycler = itemView.findViewById(R.id.rv_recycler);
        }
    }
}
