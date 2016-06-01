package demo.study.app.com.tangycstudydemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import demo.study.app.com.lib_core.BaseFragment;
import demo.study.app.com.tangycstudydemo.R;
import demo.study.app.com.tangycstudydemo.activity.SencondActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {

    public static MainFragment newInstance(){
        return new MainFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void intView(View view, Bundle savedInstanceState) {

        view.findViewById(R.id.btn_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity, SencondActivity.class));
            }
        });
    }

}
