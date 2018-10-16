package com.a110.helloworld.jump;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.a110.helloworld.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BActivity extends AppCompatActivity {

    @BindView(R.id.tv_extra)
    TextView tvExtra;
    @BindView(R.id.btn_finish)
    Button btnFinish;
    @BindView(R.id.btn_jump_b_2)
    Button btnJumpB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int number = bundle.getInt("number");

        tvExtra.setText(name + "," + number);

        Log.d("BActivity", "---------onCreate---------");
        Log.d("BActivity", "taskid:" + getTaskId() + " ,hash:" + hashCode());
        logtaskName();
    }

    @OnClick({R.id.btn_finish,R.id.btn_jump_b_2})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_finish:
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("title", "我回来了");
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK, intent);
                finish();
                break;
            case R.id.btn_jump_b_2:
                Intent intent1 = new Intent(BActivity.this, AActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.d("BActivity", "---------onCreate---------");
        Log.d("BActivity", "taskid:" + getTaskId() + " ,hash:" + hashCode());
        logtaskName();
    }

    private void logtaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity", info.taskAffinity);//所在任务栈的名称
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
