package com.example.xiangmu.presenter;

import android.util.Log;
import android.widget.HeterogeneousExpandableList;

import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.utils.net.INetCallBack;
import com.example.xiangmu.contract.MainContract;
import com.example.xiangmu.model.MainModelImpl;
import com.example.xiangmu.view.ShowBean;

public class MainPresenterImpl extends BasePresenter<MainContract.IMainView, MainContract.IMainModel> implements MainContract.IMainPresenter {

    @Override
    public void getData() {
        iModel.getMain("api/index", new INetCallBack<ShowBean>() {
            @Override
            public void onSuccess(ShowBean showBean) {
                iView.getData(showBean);
            }

            @Override
            public void onFail(String error) {
                Log.e("TAG", "解析错误(P)" + error);
            }
        });
    }

    @Override
    protected MainContract.IMainModel getModel() {
        return new MainModelImpl();
    }
}
