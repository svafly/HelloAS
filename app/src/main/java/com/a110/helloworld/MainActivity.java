package com.a110.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.a110.helloworld.fragment.ContainerActivity;
import com.a110.helloworld.jump.AActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_ui)
    Button btnUi;
    @BindView(R.id.btn_lifecycle)
    Button btnLifecycle;
    @BindView(R.id.btn_jump)
    Button btnJump;
    @BindView(R.id.btn_fragment_b)
    Button btnFragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_ui, R.id.btn_lifecycle, R.id.btn_jump, R.id.btn_fragment_b})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_ui:
                intent = new Intent(MainActivity.this, UIActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_lifecycle:
                intent = new Intent(MainActivity.this, LifeCycleActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_jump:
                intent = new Intent(MainActivity.this, AActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_fragment_b:
                intent = new Intent(MainActivity.this, ContainerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
