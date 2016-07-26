/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/
package com.zsmarter.push;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class launches the push view, allows the user to take a picture, closes the push view,
 * and returns the captured image.  When the push view is closed, the screen displayed before
 * the push view was shown is redisplayed.
 */
public class Push extends CordovaPlugin {

    public static CordovaWebView webView;


    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        LogUtils.d("...initialize...");
        Push.webView = super.webView;

    }

    /**
     * 注册推送服务
     * @param action          The action to execute.
     * @param args            The exec() arguments.
     * @param callbackContext The callback context used when calling back into JavaScript.
     * @return
     * @throws JSONException
     */
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("registPush")) {
            PushUtils.registPushService(Push.webView);
            JSONObject success = new JSONObject();
            success.put("status","00");
            success.put("msg","registComplete");
            callbackContext.success(success);
        }else if(action.equals("logoutPush")){
            PushUtils.logoutPushService();
            JSONObject success = new JSONObject();
            success.put("status","00");
            success.put("msg","logoutComplete");
            callbackContext.success(success);
        }
        return false;
    }
}
