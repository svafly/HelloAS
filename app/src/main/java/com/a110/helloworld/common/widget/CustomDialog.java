package com.a110.helloworld.common.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.a110.helloworld.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Create by vicky on 2018/10/11
 */
public class CustomDialog extends Dialog {
    @BindView(R.id.tv_custom_dialog_title)
    TextView tvCustomDialogTitle;
    @BindView(R.id.tv_custom_dialog_message)
    TextView tvCustomDialogMessage;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    private String title;
    private String message;
    private String cancel;
    private String confirm;

    private IOnCancelListener cancelListener;
    private IOnConfirmListener confirmListener;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        ButterKnife.bind(this);

        //设置宽度
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * 0.8);
        getWindow().setAttributes(p);

        if (!TextUtils.isEmpty(title)) {
            tvCustomDialogTitle.setText(title);
        }
        if (!TextUtils.isEmpty(message)) {
            tvCustomDialogMessage.setText(message);
        }
        if (!TextUtils.isEmpty(cancel)) {
            tvCancel.setText(cancel);
        }
        if (!TextUtils.isEmpty(confirm)) {
            tvConfirm.setText(confirm);
        }
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;
    }

    @OnClick({R.id.tv_confirm, R.id.tv_cancel})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                if (cancelListener != null) {
                    cancelListener.onCancel(this);
                }
                dismiss();
                break;
            case R.id.tv_confirm:
                if (confirmListener != null) {
                    confirmListener.onConfirm(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOnCancelListener {
        void onCancel(CustomDialog dialog);
    }

    public interface IOnConfirmListener {
        void onConfirm(CustomDialog dialog);
    }
}
