package com.a110.helloworld;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TextViewActivity extends AppCompatActivity {

    @BindView(R.id.tv_3)
    TextView tv3;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_4)
    TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        ButterKnife.bind(this);

        //下划线
        tv1.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        //删除线
        tv3.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv3.getPaint().setAntiAlias(true);          //去除锯齿
        //html
        tv4.setText(Html.fromHtml("<u>我自己写的<u>"));
    }
}
