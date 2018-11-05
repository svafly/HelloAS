package com.wzy.paylibrary;

/**
 * 支付宝支付请求2
 * 安全的支付宝支付流程，用法
 */
public class AliPayReq2{
    /**
     * ali pay sdk flag
     */
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_CHECK_FLAG = 2;

    private Activity mActivity;

    //未签名的订单信息
    private String rawAliPayOrderInfo;
}