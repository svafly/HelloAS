package com.a110.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RadioButtonActivity extends AppCompatActivity {

    @BindView(R.id.rg_1)
    RadioGroup rg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        ButterKnife.bind(this);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                Toast.makeText(RadioButtonActivity.this, radioButton.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
