package com.example.fragment;

import android.graphics.Color;
import android.view.View;
import android.webkit.WebView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mvplibrary.base.BaseFragment;
import com.example.xiangmu.R;
import com.example.xiangmu.contract.MainContract;
import com.example.xiangmu.presenter.MainPresenterImpl;
import com.example.xiangmu.view.BannerAdapter;
import com.example.xiangmu.view.ShowBean;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class OneFragment extends BaseFragment<MainPresenterImpl> implements MainContract.IMainView {


    private Banner banner;
    private RecyclerView mrecycler;
    private ArrayList<ShowBean.DataBean.BannerBean> bannerlist;
    private BannerAdapter bannerAdapter;
    private SingleLayoutHelper singleLayoutHelper;

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
        DelegateAdapter adapter = new DelegateAdapter(virtualLayoutManager, true);
        adapter.addAdapter(bannerAdapter);
        mrecycler.setAdapter(adapter);
    }

    private void liebiao() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(6);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        //gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格

        //网格布局管理器
        new ArrayList<ShowBean.DataBean.BannerBean>()
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
    }
}