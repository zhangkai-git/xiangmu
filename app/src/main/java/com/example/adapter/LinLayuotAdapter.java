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

public class LinLayuotAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ShowBean.DataBean.TopicListBean> topicListBeans;

    public LinLayuotAdapter(Context context, ArrayList<ShowBean.DataBean.TopicListBean> topicListBeans) {
        this.context = context;
        this.topicListBeans = topicListBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_textpic, parent, false);
        return new VH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShowBean.DataBean.TopicListBean topicListBean = topicListBeans.get(position);
        VH vh = (VH) holder;
        vh.name.setText(topicListBean.getTitle());
        vh.title.setText(topicListBean.getSubtitle());
        vh.price.setText("$" + topicListBean.getPrice_info());
        Glide.with(context).load(topicListBean.getScene_pic_url()).into(vh.image);
    }

    @Override
    public int getItemCount() {
        return topicListBeans.size();
    }

    private class VH extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView title;
        TextView price;

        public VH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.topic_image);
            name = itemView.findViewById(R.id.topic_name);
            title = itemView.findViewById(R.id.topic_title);
            price = itemView.findViewById(R.id.topic_price);
        }
    }
}
