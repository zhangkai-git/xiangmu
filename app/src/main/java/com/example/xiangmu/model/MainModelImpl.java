package com.example.xiangmu.model;

import com.example.mvplibrary.base.BaseModel;
import com.example.mvplibrary.utils.net.INetCallBack;
import com.example.mvplibrary.utils.net.RetrofitUtils;
import com.example.xiangmu.contract.MainContract;
import com.example.xiangmu.presenter.MainPresenterImpl;

public class MainModelImpl implements MainContract.IMainModel, BaseModel {
    private MainPresenterImpl mainPresenter;

    public MainModelImpl(MainPresenterImpl mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    @Override
    public <P> void getMain(String url, INetCallBack<P> callBack) {
        RetrofitUtils.getInstance().get(url, callBack);
    }
}