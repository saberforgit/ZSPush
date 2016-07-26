package com.zsmarter.push;

import android.app.Activity;

import com.minxing.kit.push.PushKit;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;

import java.lang.reflect.Method;

/**
 * Created by wangxf on 2016/7/25.
 */
public class PushUtils {
    // To inform the user about the state of the app in callbacks
    protected static Boolean isInBackground = true;
    /**
     * 注册webview对象
     * @param cordovaWebView
     */
    public static void registPushService(CordovaWebView cordovaWebView){
        LogUtils.d("...registed...");
        CordovaPersistence.getInstance().setCordovaWebView(cordovaWebView);
        startService();
    }

    public static void logoutPushService(){
        LogUtils.d("...logout...");
        CordovaPersistence.getInstance().destoryWebView();
        stopService();
    }

    public static void startService(){
        //开始接收敏推消息
        LogUtils.d("...registedPushService...");
        PushKit.getInstance().start();
    }

    public static void stopService(){
        //结束接收敏推消息
        LogUtils.d("...logoutPushService...");
        PushKit.getInstance().stop();
    }


    public static void schedule (CordovaWebView cordovaWebView,String event, JSONArray notification) {
        String state = getApplicationState();
        String params = "\"" + state + "\"";

        if (notification != null) {
            params = notification.toString() + "," + params;
        }

        String js = "Push.fireEvent(" +
                "\"" + event + "\"," + params + ")";

        sendJavascript(cordovaWebView,js);
    }


    private static synchronized void sendJavascript(final CordovaWebView cordovaWebView, final String js) {
        LogUtils.d(js);
        Runnable jsLoader = new Runnable() {
            public void run() {
                cordovaWebView.loadUrl("javascript:" + js);
            }
        };
        try {
            Method post = cordovaWebView.getClass().getMethod("post",Runnable.class);
            post.invoke(cordovaWebView,jsLoader);
        } catch(Exception e) {

            ((Activity)(cordovaWebView.getContext())).runOnUiThread(jsLoader);
        }
    }


    private static String getApplicationState () {
        return isInBackground ? "background" : "foreground";
    }
}
