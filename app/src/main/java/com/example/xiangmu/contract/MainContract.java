package com.example.xiangmu.contract;

import com.example.mvplibrary.base.BaseModel;
import com.example.mvplibrary.base.BaseView;
import com.example.mvplibrary.utils.net.INetCallBack;
import com.example.xiangmu.view.ShowBean;

public class MainContract {
    public interface IMainModel extends BaseModel {
        <P> void getMain(String url, INetCallBack<P> callBack);
    }
    public interface IMainView extends BaseView {
        void getData(ShowBean showBean);
    }
    public interface IMainPresenter{
        void getPresenterData();
    }
}
