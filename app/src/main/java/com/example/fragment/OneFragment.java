package com.example.fragment;

import android.view.View;
import android.webkit.WebView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View inflate) {
        banner = getActivity().findViewById(R.id.banner);
        RecyclerView mrecycler = getActivity().findViewById(R.id.rv_recycler);

        mrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        mrecycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));

        bannerlist = new ArrayList<>();
        bannerAdapter = new BannerAdapter(getActivity(), bannerlist);

        mrecycler.setLayoutManager(bannerAdapter);
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

    }
}
