package com.a110.helloworld.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.a110.helloworld.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Create by vicky on 2018/10/15
 */
public class AFragment extends Fragment {
    @BindView(R.id.btn_change)
    Button btnChange;
    @BindView(R.id.btn_change_tv)
    Button btnChangeTv;
    @BindView(R.id.tv_a)
    TextView tvA;
    Unbinder unbinder;
    @BindView(R.id.btn_message)
    Button btnMessage;

//    private Activity mActivity;
    private BFragment bFragment;
    private IOnMessageClick listener;

    public static AFragment newInstance(String title) {
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        unbinder = ButterKnife.bind(this, view);
        Log.d("AFragmemt-onCreateView", "-------onCreateView-------");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvA = view.findViewById(R.id.tv_a);
        if (getArguments() != null) {
            tvA.setText(getArguments().getString("title"));
        }
//        if (getActivity() != null) {
//
//        } else {
//
//        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        mActivity = (Activity) context;         //这个方法不建议，可能会有内存泄露

        try{
            listener = (IOnMessageClick) context;
        } catch (ClassCastException e){
            throw new ClassCastException("Activity 必须实现 IOnMessageClick接口");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //当fragment脱离activity的时候，这里可以取消异步
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_change, R.id.btn_change_tv, R.id.btn_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_change:
                if (bFragment == null) {
                    bFragment = new BFragment();
                }
                Fragment aFragment = getFragmentManager().findFragmentByTag("a");
                if (aFragment == null) {
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                } else {
                    getFragmentManager().beginTransaction().hide(aFragment).add(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }

                break;
            case R.id.btn_change_tv:
                tvA.setText("我是新文字");
                break;
            case R.id.btn_message:
                //土方法
//                ((ContainerActivity)getActivity()).setData("你好");
                listener.onClick("你好");
                break;
        }
    }

    public interface IOnMessageClick{
        void onClick(String str);
    }
}
