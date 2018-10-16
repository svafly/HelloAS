package com.a110.helloworld.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.a110.helloworld.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {

    //    @BindView(R.id.btn_change)
//    Button btnChange;
    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private AFragment aFragment;
    private BFragment bFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        ButterKnife.bind(this);

        aFragment = AFragment.newInstance("我是参数");
//        bFragment = new BFragment();
        //
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment, "a").commitAllowingStateLoss();
    }

//    @OnClick(R.id.btn_change)
//    public void onViewClicked() {
//        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
//    }

    public void setData(String str){
        tvTitle.setText(str);
    }

    @Override
    public void onClick(String str) {
        tvTitle.setText(str);
    }
}
