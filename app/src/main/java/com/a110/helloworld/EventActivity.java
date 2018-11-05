package com.a110.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.a110.helloworld.common.widget.MyButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventActivity extends AppCompatActivity {

    @BindView(R.id.btn_event_1)
    Button btnEvent1;
    @BindView(R.id.btn_event_2)
    MyButton btnEvent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_event_1,R.id.btn_event_2})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_event_1:
                Toast.makeText(EventActivity.this, "click...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_event_2:
                Log.d("Listener","---onClick---");
                Toast.makeText(EventActivity.this,"click.",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity","---onTouchEvent---");
                break;
        }
        return false;
    }
}
