package com.wzy.paylibrary;


import android.media.audiofx.DynamicsProcessing;

/**
 * 支付宝支付API
 * 使用：
 * AliPayAPI.getInstance().apply(config).sendPayReg(aliPayReg)
 *
 * Create by vicky on 2018/11/5
 */
public class AliPayAPI {
    private Config mConfig;

    private static final Object mLock = new Object();
    private static AliPayAPI mInstance;

    /**
     * 获取支付宝支付API
     * @return
     */
    public static AliPayAPI getInstance(){
        if (mInstance == null){
            synchronized (mLock){
                if (mInstance == null){
                    mInstance = new AliPayAPI();
                }
            }
        }
        return mInstance;
    }

    /**
     * 配置支付宝配置
     * @param config
     * @return
     */
    public AliPayAPI apply(Config config){
        this.mConfig = config;
        return this;
    }

    public void sendPayReq(AliPayReq aliPayReq){
        aliPayReq.send();
    }
    public static class Config{

    }
}
