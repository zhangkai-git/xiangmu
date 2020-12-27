package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.bean.ShowBean;
import com.example.xiangmu.R;

import java.util.ArrayList;

public class TextJAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<ShowBean.DataBean.CategoryListBean> list;
    private LinearLayoutHelper linearLayoutHelper;

    public TextJAdapter(Context context, ArrayList<ShowBean.DataBean.CategoryListBean> list, LinearLayoutHelper linearLayoutHelper) {
        this.context = context;
        this.list = list;
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_jujia, parent, false);
        return new TextVH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShowBean.DataBean.CategoryListBean categoryListBean = list.get(0);
        TextVH vh = (TextVH) holder;
        vh.name.setText(categoryListBean.getName());
    }

    @Override
    public int getItemCount() {
        return list.size()-8 ;
    }

    private class TextVH extends RecyclerView.ViewHolder {
        TextView name;

        public TextVH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_text_jujia_name);
        }
    }
}