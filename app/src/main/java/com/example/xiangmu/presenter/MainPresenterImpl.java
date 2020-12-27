package com.example.xiangmu.presenter;

import android.util.Log;

import com.example.fragment.OneFragment;
import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.utils.net.INetCallBack;
import com.example.mvplibrary.utils.net.URLContant;
import com.example.xiangmu.contract.MainContract;
import com.example.xiangmu.model.MainModelImpl;
import com.example.bean.ShowBean;

public class MainPresenterImpl extends BasePresenter<OneFragment,MainModelImpl> implements MainContract.IMainPresenter {

    @Override
    public void getPresenterData() {
        iModel.getMain(URLContant.URL, new INetCallBack<ShowBean>() {
            @Override
            public void onSuccess(ShowBean showBean) {
                iView.getData(showBean);
            }

            @Override
            public void onFail(String error) {
                Log.e("TAG", "解析错误: "+error );
            }
        });
    }

    @Override
    public MainModelImpl getModel() {
        return new MainModelImpl(this);
    }
}
