package com.a110.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToastActivity extends AppCompatActivity {

    @BindView(R.id.btn_toast_1)
    Button btnToast1;
    @BindView(R.id.btn_toast_2)
    Button btnToast2;
    @BindView(R.id.btn_toast_3)
    Button btnToast3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_toast_1, R.id.btn_toast_2, R.id.btn_toast_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_toast_1:
                Toast.makeText(ToastActivity.this,"Toast",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_toast_2:
                Toast toastCenter = Toast.makeText(ToastActivity.this,"居中Toast",Toast.LENGTH_SHORT);
                toastCenter.setGravity(Gravity.CENTER,0,0);
                toastCenter.show();
                break;
            case R.id.btn_toast_3:
                Toast toastCustom = new Toast(getApplicationContext());
                LayoutInflater layoutInflater = LayoutInflater.from(ToastActivity.this);
                View view1 = layoutInflater.inflate(R.layout.layout_toast,null);
                ImageView imageView = view1.findViewById(R.id.iv_toast);
                TextView textView = view1.findViewById(R.id.tv_toast);
                imageView.setImageResource(R.drawable.bg_japan_famous);
                textView.setText("自定义Toast");
                toastCustom.setView(view1);
                toastCustom.show();
                break;
        }
    }
}
