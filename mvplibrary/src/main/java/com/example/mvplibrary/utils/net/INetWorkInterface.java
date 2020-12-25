package com.example.mvplibrary.utils.net;

public interface INetWorkInterface {
    <P> void get(String url, INetCallBack<P> callBack);
}
