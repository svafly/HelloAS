package com.a110.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.a110.helloworld.gridview.GridViewActivity;
import com.a110.helloworld.listview.ListViewActivity;
import com.a110.helloworld.recyclerview.RecyclerViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.button_1)
    Button button1;
    @BindView(R.id.btn_button)
    Button btnButton;
    @BindView(R.id.btn_edittext)
    Button btnEdittext;
    @BindView(R.id.btn_radiobutton)
    Button btnRadiobutton;
    @BindView(R.id.btn_checkbox)
    Button btnCheckbox;
    @BindView(R.id.btn_imageview)
    Button btnImageview;
    @BindView(R.id.btn_listview)
    Button btnListview;
    @BindView(R.id.btn_gridview)
    Button btnGridview;
    @BindView(R.id.btn_recyclerview)
    Button btnRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_1, R.id.btn_button, R.id.btn_edittext, R.id.btn_radiobutton, R.id.btn_checkbox, R.id.btn_imageview, R.id.btn_listview, R.id.btn_gridview, R.id.btn_recyclerview})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.button_1:
                //跳转到TextView界面
                intent = new Intent(MainActivity.this, TextViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_button:
                intent = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_edittext:
                intent = new Intent(MainActivity.this, EditTextActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_radiobutton:
                intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_checkbox:
                //跳转到CheckBox演示界面
                intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_imageview:
                //跳转到CheckBox演示界面
                intent = new Intent(MainActivity.this, ImageViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_listview:
                //跳转到ListView演示界面
                intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_gridview:
                intent = new Intent(MainActivity.this, GridViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_recyclerview:
                intent = new Intent(MainActivity.this,RecyclerViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
