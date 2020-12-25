package com.example.xiangmu.model;

import com.example.mvplibrary.utils.net.INetCallBack;
import com.example.mvplibrary.utils.net.RetrofitUtils;
import com.example.xiangmu.contract.MainContract;

public class MainModelImpl implements MainContract.IMainModel {


    @Override
    public <P> void getMain(String url, INetCallBack<P> callBack) {
        RetrofitUtils.getInstance().get(url, callBack);
    }
}
