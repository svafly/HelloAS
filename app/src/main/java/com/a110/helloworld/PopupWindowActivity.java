package com.a110.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PopupWindowActivity extends AppCompatActivity {

    @BindView(R.id.btn_popup)
    Button btnPopup;

    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_popup)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btn_popup:
                View view1 = getLayoutInflater().inflate(R.layout.layout_pop,null);
                popupWindow = new PopupWindow(view1,btnPopup.getWidth(),ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView textView = view1.findViewById(R.id.tv_good);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        Toast.makeText(PopupWindowActivity.this,"好",Toast.LENGTH_SHORT).show();
                    }
                });

                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(btnPopup);
                break;
        }
    }
}
