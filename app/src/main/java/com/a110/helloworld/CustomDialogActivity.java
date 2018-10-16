package com.a110.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.a110.helloworld.common.widget.CustomDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDialogActivity extends AppCompatActivity {

    @BindView(R.id.btn_custom_dialog)
    Button btnCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_custom_dialog)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btn_custom_dialog:
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示").setMessage("确认删除此项？").setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        Toast.makeText(CustomDialogActivity.this,"cancel",Toast.LENGTH_SHORT).show();
                    }
                }).setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                        Toast.makeText(CustomDialogActivity.this,"confirm",Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
        }
    }
}
