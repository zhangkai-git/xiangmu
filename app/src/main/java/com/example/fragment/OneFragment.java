package com.example.fragment;

import android.graphics.Color;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.adapter.WenAdapter;
import com.example.mvplibrary.base.BaseFragment;
import com.example.xiangmu.R;
import com.example.xiangmu.contract.MainContract;
import com.example.xiangmu.presenter.MainPresenterImpl;
import com.example.adapter.BannerAdapter;
import com.example.adapter.OneAdapter;
import com.example.bean.ShowBean;

import java.util.ArrayList;
import java.util.List;

public class OneFragment extends BaseFragment<MainPresenterImpl> implements MainContract.IMainView {


    private RecyclerView mrecycler;
    private ArrayList<ShowBean.DataBean.BannerBean> bannerlist;
    private BannerAdapter bannerAdapter;
    private ArrayList<ShowBean.DataBean.ChannelBean> list;
    private OneAdapter oneAdapter;
    private WenAdapter wenAdapter;

    @Override
    protected void initView(View inflate) {
        mrecycler = inflate.findViewById(R.id.rv_recycler);
        //布局管理
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        mrecycler.setLayoutManager(virtualLayoutManager);
        //组件复用
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        mrecycler.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0, 10);
        banner();
        liebiao();
        text();
        DelegateAdapter adapter = new DelegateAdapter(virtualLayoutManager, true);
        adapter.addAdapter(bannerAdapter);
        adapter.addAdapter(oneAdapter);
        adapter.addAdapter(wenAdapter);
        mrecycler.setAdapter(adapter);
    }

    private void text() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色

        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        wenAdapter = new WenAdapter(getActivity(), linearLayoutHelper);
    }

    private void liebiao() {
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 创建对象

        // 公共属性
        columnLayoutHelper.setItemCount(5);// 设置布局里Item个数
        columnLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        columnLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        // columnLayoutHelper特有属性
        columnLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});// 设置该行每个Item占该行总宽度的比例
        list = new ArrayList<>();
        oneAdapter = new OneAdapter(getActivity(), list, columnLayoutHelper);
    }

    private void banner() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色

        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        bannerlist = new ArrayList<>();
        bannerAdapter = new BannerAdapter(getActivity(), bannerlist, linearLayoutHelper);
    }

    @Override
    protected void initData() {
        Presenter.getPresenterData();
    }

    @Override
    protected MainPresenterImpl getPresenter() {
        return new MainPresenterImpl();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_one;
    }

    @Override
    public void getData(ShowBean showBean) {
        List<ShowBean.DataBean.BannerBean> banner = showBean.getData().getBanner();
        bannerlist.addAll(banner);
        bannerAdapter.notifyDataSetChanged();
        List<ShowBean.DataBean.ChannelBean> channel = showBean.getData().getChannel();
        list.addAll(channel);
        oneAdapter.notifyDataSetChanged();
    }
}