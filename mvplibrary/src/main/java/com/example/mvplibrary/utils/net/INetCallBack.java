package com.example.mvplibrary.utils.net;

public interface INetCallBack<P> {
    void onSuccess(P p);
    void onFail(String error);
}
