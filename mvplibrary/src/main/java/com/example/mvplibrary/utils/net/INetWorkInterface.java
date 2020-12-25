package com.example.mvplibrary.utils.net;

public interface INetWorkInterface {
    public <P> void get(String url, INetCallBack<P> callBack);
}
