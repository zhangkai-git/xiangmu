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
import com.bumptech.glide.load.resource.gif.GifBitmapProvider;
import com.example.bean.ShowBean;
import com.example.xiangmu.R;

import java.util.ArrayList;

public class TopicAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<ShowBean.DataBean.TopicListBean> topiclist;
    private GridLayoutHelper gridLayoutHelper;

    public TopicAdapter(Context context, ArrayList<ShowBean.DataBean.TopicListBean> topiclist, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.topiclist = topiclist;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_topic, parent, false);
        return new TopicVH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShowBean.DataBean.TopicListBean topicListBean = topiclist.get(position);
        TopicVH vh = (TopicVH) holder;
        vh.name.setText(topicListBean.getTitle());
        vh.price.setText(topicListBean.getPrice_info() + "元起");
        vh.title.setText(topicListBean.getSubtitle());
        Glide.with(context).load(topicListBean.getScene_pic_url()).into(vh.image);
    }

    @Override
    public int getItemCount() {
        return topiclist.size();
    }

    private class TopicVH extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView title;
        TextView price;

        public TopicVH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.topic_image);
            name = itemView.findViewById(R.id.topic_name);
            title = itemView.findViewById(R.id.topic_title);
            price = itemView.findViewById(R.id.topic_price);
        }
    }
}
