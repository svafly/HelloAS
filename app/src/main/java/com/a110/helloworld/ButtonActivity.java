package com.a110.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButtonActivity extends AppCompatActivity {

    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.tv_1)
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        ButterKnife.bind(this);
    }

    public void showToast(View view) {
        Toast.makeText(this, "我被点击了", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.btn_3,R.id.tv_1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_3:
                Toast.makeText(this, "button3被点击了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_1:
                Toast.makeText(this,"TextView1被点击了",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
