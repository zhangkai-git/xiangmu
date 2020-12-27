package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.example.xiangmu.R;

import java.util.ArrayList;

public class WenAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper;

    public WenAdapter(Context context, LinearLayoutHelper linearLayoutHelper) {
        this.context = context;
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_text, parent, false);
        return new VH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh = (VH) holder;
        vh.name.setText("品牌制造商直供");
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class VH extends RecyclerView.ViewHolder {
        TextView name;

        public VH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_text_name);
        }
    }
}
