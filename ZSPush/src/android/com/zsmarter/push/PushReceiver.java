package com.zsmarter.push;

import android.content.Context;
import android.widget.Toast;
import com.minxing.kit.push.MXPushReceiver;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by wangxf on 2016/7/25.
 */
public class PushReceiver extends MXPushReceiver {

    @Override
    public void onMessage(Context context, String s) {
        LogUtils.d("...msg receive...");
        if(CordovaPersistence.getInstance().getCordovaWebView()==null){
            Toast.makeText(context,"未注册Push服务，请先注册",Toast.LENGTH_SHORT).show();
            return;
        }
        JSONArray jsonArray = new JSONArray();
        try {
            jsonArray.put(new JSONObject().put("msg",s));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PushUtils.schedule(CordovaPersistence.getInstance().getCordovaWebView(),"receiveMsg",jsonArray);
    }
}
