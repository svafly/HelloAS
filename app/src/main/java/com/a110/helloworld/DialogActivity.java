package com.a110.helloworld;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.a110.helloworld.common.utils.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends AppCompatActivity {

    @BindView(R.id.btn_dialog1)
    Button btnDialog1;
    @BindView(R.id.btn_dialog2)
    Button btnDialog2;
    @BindView(R.id.btn_dialog3)
    Button btnDialog3;
    @BindView(R.id.btn_dialog4)
    Button btnDialog4;
    @BindView(R.id.btn_dialog5)
    Button btnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_dialog1, R.id.btn_dialog2, R.id.btn_dialog3, R.id.btn_dialog4, R.id.btn_dialog5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_dialog1:
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                builder.setTitle("请回答").setMessage("你觉得怎么样？")
                        .setIcon(R.drawable.icon_user).setPositiveButton("棒", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "你很诚实", Toast.LENGTH_SHORT).show();
                    }
                }).setNeutralButton("还行", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "你再瞅瞅~！", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("不好", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "睁眼说瞎话！", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.btn_dialog2:
                final String[] array = new String[]{"男", "女"};
                AlertDialog.Builder builder1 = new AlertDialog.Builder(DialogActivity.this);
                builder1.setTitle("选择性别").setItems(array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "click:" + array[which], Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.btn_dialog3:
                final String[] array2 = new String[]{"男", "女"};
                AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                builder2.setSingleChoiceItems(array2, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "select:" + array2[which], Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.btn_dialog4:
                final String[] array3 = new String[]{"唱歌", "跳舞", "写代码"};
                boolean[] isSelected = new boolean[]{false, false, true};
                AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                builder3.setTitle("选择兴趣").setMultiChoiceItems(array3, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(DialogActivity.this, array3[which] + ":" + isChecked, Toast.LENGTH_SHORT).show();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO
                    }
                }).show();
                break;
            case R.id.btn_dialog5:
                AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                View view1 = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog,null);
                final EditText editText = view1.findViewById(R.id.et_name);
                TextView textView = view1.findViewById(R.id.tv_confirm);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("realName","xingming:"+editText.getText().toString().trim());
                        if (StringUtil.isBlank(editText.getText().toString())){
                            Toast.makeText(DialogActivity.this,"请输入真实姓名",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(DialogActivity.this,"生成中...",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder4.setView(view1).show();
                break;
        }
    }
}
