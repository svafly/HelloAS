package com.wzy.paylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void testWechatPay(){
        String appid        = "";
        String partnerid    = "";
        String prepayid     = "";
        String noncestr     = "";
        String timestamp    = "";
        String sign         = "";
        WechatPayReq wechatPayReq = new WechatPayReq.Builder()
                .with(this)         //activity实例
                .setAppId(appid)    //微信支付AppID
                .setPartnerId(partnerid)    //微信支付商户号
                .setPrepayId(prepayid)      //预支付码（重要）
//                .setPackageValue(wechatPayReq.get)//"Sign=WXPay"
                .setNonceStr(noncestr)      //
                .setTimeStamp(timestamp)    //时间戳
                .setSign(sign)              //签名
                .create();


    }
}
