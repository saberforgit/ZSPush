package com.zsmarter.push;

import com.minxing.kit.push.MXPushApplication;
import com.minxing.kit.push.PushKit;

public class AppApplication extends MXPushApplication {
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		//初始化敏推
		//参数: 1. host 敏推服务端地址   2. adminHost 敏推管理端地址 3. appKey 敏推服务端页面获得的app key 4. context 应用context
		PushKit.getInstance().init("ssl://push.zsmarter.com:1883", "http://push.zsmarter.com:80", "0019c72a13507bab338984684d81f678d2f5", getApplicationContext());

	}

}
