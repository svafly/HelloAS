package com.wzy.paylibrary;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import com.wzy.paylibrary.alipay.PayResult;

/**
 * Create by vicky on 2018/11/5
 */
public class AliPayReq {
    /**
     * ali pay sdk flag
     */
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_CHECK_FLAG = 2;

    private Activity mActivity;

    //支付宝支付的配置
    private AliPayAPI.Config mConfig;

    //商户网站唯一订单号
    private String outTradeNo;
    //商品名称
    private String subject;
    //商品详情
    private String body;
    //商品金额
    private String price;
    //服务器异步通知页面路径
    private String callbackUrl;

    private Handler mHandler;

    public AliPayReq(){
        super();
        mHandler = new Handler(){

            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case SDK_PAY_FLAG:
                        PayResult payResult = new PayResult((String)msg.obj);

                        // 支付宝返回此次支付结果及加签，建议对支付宝签名信息拿签约时支付宝提供的公钥做验签
                        break;
                    case SDK_CHECK_FLAG:

                        break;
                    default:
                            break;
                }
            }
        };
    }

    public void send() {

    }
}
