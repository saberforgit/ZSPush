package com.zsmarter.push;

import org.apache.cordova.CordovaWebView;

/**
 * Created by wangxf on 2016/7/25.
 */
public class CordovaPersistence {
    private static CordovaPersistence callBackInter;
    private CordovaWebView cordovaWebView;
    private CordovaPersistence(){}
    public static CordovaPersistence getInstance(){
        if(callBackInter==null){
            callBackInter = new CordovaPersistence();
        }
        return callBackInter;
    }

    public CordovaWebView getCordovaWebView() {
        return cordovaWebView;
    }

    public void setCordovaWebView(CordovaWebView cordovaWebView) {
        this.cordovaWebView = cordovaWebView;
    }

    public void destoryWebView(){
        if(this.cordovaWebView==null){
            return;
        }
        this.cordovaWebView = null;
    }
}
