package com.a110.helloworld.jump;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.a110.helloworld.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AActivity extends AppCompatActivity {

    @BindView(R.id.btn_tob)
    Button btnTob;
    @BindView(R.id.btn_jump_2)
    Button btnJump2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        ButterKnife.bind(this);

        Log.d("AActivity", "---------onCreate---------");
        Log.d("AActivity", "taskid:" + getTaskId() + " ,hash:" + hashCode());
        logtaskName();
    }

    @OnClick({R.id.btn_tob, R.id.btn_jump_2})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_tob:
                //显示跳转1
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "妖精");
                bundle.putInt("number", 123);
                intent.putExtras(bundle);
//                startActivity(intent);
                startActivityForResult(intent, 0);
//                //显示跳转2
//                Intent intent1 = new Intent();
//                intent1.setClass(this,BActivity.class);
//                startActivity(intent1);
//                //显示跳转3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"com.a110.helloworld.jump.BActivity");
//                startActivity(intent);
//                //显示跳转4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"com.a110.helloworld.jump.BActivity"));
//                startActivity(intent);


//                //隐式1
//                Intent intent = new Intent();
//                intent.setAction("com.a110.helloworld.BActivity");
//                startActivity(intent);
                break;
            case R.id.btn_jump_2:
                Intent intent1 = new Intent(AActivity.this, AActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this, "value:" + data.getExtras().getString("title"), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.d("AActivity", "---------onCreate---------");
        Log.d("AActivity", "taskid:" + getTaskId() + " ,hash:" + hashCode());
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
