package com.a110.helloworld.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.a110.helloworld.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.btn_linear)
    Button btnLinear;
    @BindView(R.id.btn_hor)
    Button btnHor;
    @BindView(R.id.btn_grid)
    Button btnGrid;
    @BindView(R.id.btn_pu)
    Button btnPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_linear, R.id.btn_hor, R.id.btn_grid, R.id.btn_pu})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_linear:
                intent = new Intent(RecyclerViewActivity.this, LinearRecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_hor:
                intent = new Intent(RecyclerViewActivity.this, HorRecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_grid:
                intent = new Intent(RecyclerViewActivity.this, GridRecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_pu:
                intent = new Intent(RecyclerViewActivity.this, PuRecyclerViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
