package com.example.fragment;

import android.graphics.Color;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.adapter.CateGoryAdapter;
import com.example.adapter.CateGoryAdapter1;
import com.example.adapter.HotGoodsAdapter;
import com.example.adapter.ImagevAdapter;
import com.example.adapter.NewGoodsAdapter;
import com.example.adapter.TextCAdapter;
import com.example.adapter.TextJAdapter;
import com.example.adapter.TextNAdapter;
import com.example.adapter.TextRAdapter;
import com.example.adapter.TextZAdapter;
import com.example.adapter.TopicAdapter;
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


    int _pos;
    private RecyclerView mrecycler;
    private ArrayList<ShowBean.DataBean.BannerBean> bannerlist;
    private BannerAdapter bannerAdapter;
    private ArrayList<ShowBean.DataBean.ChannelBean> list;
    private OneAdapter oneAdapter;
    private ImagevAdapter imagevAdapter;
    private ArrayList<ShowBean.DataBean.BrandListBean> brandlist;
    private DelegateAdapter adapter;
    private WenAdapter wenAdapter;
    private TextNAdapter textNAdapter;
    private ArrayList<ShowBean.DataBean.NewGoodsListBean> newgoodslist;
    private NewGoodsAdapter newGoodsAdapter;
    private TextRAdapter textRAdapter;
    private ArrayList<ShowBean.DataBean.HotGoodsListBean> hotgoodslist;
    private HotGoodsAdapter hotGoodsAdapter;
    private TextZAdapter textZAdapter;
    private ArrayList<ShowBean.DataBean.TopicListBean> toplist;
    private TopicAdapter topicAdapter;
    private TextJAdapter textJAdapter;
    private ArrayList<ShowBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans;
    private CateGoryAdapter cateGoryAdapter;
    private ArrayList<ShowBean.DataBean.CategoryListBean> categoryListBeans;
    private ArrayList<ShowBean.DataBean.CategoryListBean> categoryListBeans1;
    private TextCAdapter textCAdapter;
    private ArrayList<ShowBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans1;

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
        texttwo();
        imagev();
        textnew();
        newgoods();
        textrenqi();
        hotgoods();
        textzhuanti();
        topic();
        textjujia();
        category();
        textcanchu();
        category1();
        DelegateAdapter adapter = new DelegateAdapter(virtualLayoutManager);
        adapter.addAdapter(bannerAdapter);
        adapter.addAdapter(oneAdapter);
        adapter.addAdapter(wenAdapter);
        adapter.addAdapter(imagevAdapter);
        adapter.addAdapter(textNAdapter);
        adapter.addAdapter(newGoodsAdapter);
        adapter.addAdapter(textRAdapter);
        adapter.addAdapter(hotGoodsAdapter);
        adapter.addAdapter(textZAdapter);
        adapter.addAdapter(topicAdapter);
        adapter.addAdapter(textJAdapter);
        adapter.addAdapter(cateGoryAdapter);
        adapter.addAdapter(textCAdapter);
        mrecycler.setAdapter(adapter);
    }

    private void category1() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setItemCount(4);
        //网格布局管理器
        goodsListBeans1 = new ArrayList<>();
        new CateGoryAdapter1(getActivity(), goodsListBeans1, gridLayoutHelper);
    }

    private void textcanchu() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);
        categoryListBeans1 = new ArrayList<>();
        textCAdapter = new TextCAdapter(getActivity(), categoryListBeans1, linearLayoutHelper);
    }

    private void category() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setItemCount(4);
        //网格布局管理器
        goodsListBeans = new ArrayList<>();
        cateGoryAdapter = new CateGoryAdapter(getActivity(), goodsListBeans, gridLayoutHelper);
    }

    private void textjujia() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);
        categoryListBeans = new ArrayList<>();
        textJAdapter = new TextJAdapter(getActivity(), categoryListBeans, linearLayoutHelper);
    }

    private void topic() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setItemCount(4);
        //网格布局管理器
        toplist = new ArrayList<>();
        topicAdapter = new TopicAdapter(getActivity(), toplist, gridLayoutHelper);
    }

    private void textzhuanti() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);
        textZAdapter = new TextZAdapter(getActivity(), linearLayoutHelper);
    }

    private void hotgoods() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(1);
        gridLayoutHelper.setItemCount(3);
        //网格布局管理器
        hotgoodslist = new ArrayList<>();
        hotGoodsAdapter = new HotGoodsAdapter(getActivity(), hotgoodslist, gridLayoutHelper);
    }

    private void textrenqi() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);
        textRAdapter = new TextRAdapter(getActivity(), linearLayoutHelper);
    }

    private void newgoods() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setItemCount(4);
        //网格布局管理器
        newgoodslist = new ArrayList<>();
        newGoodsAdapter = new NewGoodsAdapter(getActivity(), newgoodslist, gridLayoutHelper);
    }

    private void textnew() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);
        textNAdapter = new TextNAdapter(getActivity(), linearLayoutHelper);
    }

    private void imagev() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setItemCount(4);
        //网格布局管理器
        brandlist = new ArrayList<>();
        imagevAdapter = new ImagevAdapter(getActivity(), brandlist, gridLayoutHelper);
    }

    private void texttwo() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数

        // linearLayoutHelper特有属性
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
        List<ShowBean.DataBean.BrandListBean> brandList = showBean.getData().getBrandList();
        brandlist.addAll(brandList);
        imagevAdapter.notifyDataSetChanged();
        List<ShowBean.DataBean.NewGoodsListBean> newGoodsList = showBean.getData().getNewGoodsList();
        newgoodslist.addAll(newGoodsList);
        newGoodsAdapter.notifyDataSetChanged();
        List<ShowBean.DataBean.HotGoodsListBean> hotGoodsList = showBean.getData().getHotGoodsList();
        hotgoodslist.addAll(hotGoodsList);
        hotGoodsAdapter.notifyDataSetChanged();
        List<ShowBean.DataBean.TopicListBean> topicList = showBean.getData().getTopicList();
        toplist.addAll(topicList);
        topicAdapter.notifyDataSetChanged();
        List<ShowBean.DataBean.CategoryListBean> categoryList = showBean.getData().getCategoryList();
        categoryListBeans.addAll(categoryList);
        textJAdapter.notifyDataSetChanged();
        List<ShowBean.DataBean.CategoryListBean.GoodsListBean> goodsList = showBean.getData().getCategoryList().get(_pos).getGoodsList();
        goodsListBeans.addAll(goodsList);
        cateGoryAdapter.notifyDataSetChanged();
        List<ShowBean.DataBean.CategoryListBean> categoryList1 = showBean.getData().getCategoryList();
        categoryListBeans1.addAll(categoryList1);
        textCAdapter.notifyDataSetChanged();
        List<ShowBean.DataBean.CategoryListBean.GoodsListBean> goodsList1 = showBean.getData().getCategoryList().get(_pos).getGoodsList();
        goodsListBeans1.addAll(goodsList);
        cateGoryAdapter.notifyDataSetChanged();

    }
}