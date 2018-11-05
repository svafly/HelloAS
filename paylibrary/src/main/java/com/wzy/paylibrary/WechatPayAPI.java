package com.wzy.paylibrary;

/**
 * 微信支付API
 * 使用：
 * WechatPayAPI.getInstance.sendPayReq(wechatPayReq);
 * Create by vicky on 2018/11/5
 */
public class WechatPayAPI {
    private  static final Object mLock = new Object();
    private static WechatPayAPI mInstance;

    public static WechatPayAPI getInstance(){
        if (mInstance == null){
            synchronized (mLock){
                if (mInstance == null){
                    mInstance = new WechatPayAPI();
                }
            }
        }
        return mInstance;
    }

    /**
     * 发送微信支付请求
     * @param wechatPayReq
     */
    public void sendPayReq(WechatPayReq wechatPayReq){
        wechatPayReq.send();
    }

}
