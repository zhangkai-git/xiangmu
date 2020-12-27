package com.example.mvplibrary.utils.net;

import java.net.Inet4Address;

public interface INetWorkInterface {
    <P> void get(String url, INetCallBack<P> callBack);

    <p> void gettwo(String url, INetCallBack<p> callBack);
}
