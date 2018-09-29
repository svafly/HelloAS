package com.a110.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.button_1)
    Button button1;
    @BindView(R.id.btn_button)
    Button btnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_1, R.id.btn_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_1:
                //跳转到TextView界面
                Intent intent = new Intent(MainActivity.this, TextViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_button:
                Intent intent1 = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(intent1);
                break;
        }

    }
}
