package com.a110.helloworld;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.wv_1)
    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);

//        wv1.loadUrl("file:///android_asset/test.html");
        //加载网络URL
//        wv1.loadUrl("http://xxapi.beeways.cn/Temp/showActivityContent?act_id=167&isapp=1");
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setWebViewClient(new MyWebViewClient());
        wv1.setWebChromeClient(new MyWebChromeClient());
        wv1.loadUrl("https://m.baidu.com");
    }

    class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView","onPageStarted...");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView","onPageFinished...");
//            wv1.loadUrl("javascript:alert('hello')");
            wv1.evaluateJavascript("javascript:alert('hello')",null);
        }
    }

    class MyWebChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            //设置当前app标题为当前网页标题
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && wv1.canGoBack()){
            wv1.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
