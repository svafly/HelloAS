package com.wzy.paylibrary;

/**
 * Create by vicky on 2018/11/5
 */
public class PayAPI {
    private static final Object mLock = new Object();
    private static PayAPI mInstance;

    public static PayAPI getInstance(){
        if (mInstance == null){
            synchronized (mLock){
                if (mInstance == null){
                    mInstance = new PayAPI();
                }
            }
        }
        return mInstance;
    }

    /**
     * 支付宝支付请求
     * @param aliPayReq
     */
    public void sendPayRequest(AliPayReq aliPayReq){
        AliPayAPI.getInstance().sendPayReq(aliPayReq);
    }

    public void sendPayRequest(WechatPayReq wechatPayReq){
        WechatPayAPI.getInstance().sendPayReq(wechatPayReq);
    }
}
