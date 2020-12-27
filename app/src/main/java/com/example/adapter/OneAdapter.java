package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.xiangmu.R;
import com.example.bean.ShowBean;

import java.util.ArrayList;

public class OneAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<ShowBean.DataBean.ChannelBean> list;
    private ColumnLayoutHelper columnLayoutHelper;

    public OneAdapter(Context context, ArrayList<ShowBean.DataBean.ChannelBean> list, ColumnLayoutHelper columnLayoutHelper) {
        this.context = context;
        this.list = list;
        this.columnLayoutHelper = columnLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return columnLayoutHelper;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_one, parent, false);
        return new VHH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VHH vhh = (VHH) holder;
        ShowBean.DataBean.ChannelBean channelBean = list.get(position);
        vhh.name.setText(channelBean.getName());
        Glide.with(context).load(channelBean.getIcon_url()).into(vhh.image);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VHH extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;

        public VHH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_image);
            name = itemView.findViewById(R.id.tv_name);
        }
    }
}
