package demo.study.app.com.tangycstudydemo.base_abstract.activity;

import android.content.Intent;

import demo.study.app.com.lib_core.BaseFragment;
import demo.study.app.com.tangycstudydemo.base_abstract.AppActivity;
import demo.study.app.com.tangycstudydemo.base_abstract.fragment.MainFragment;


public class MainActivity extends AppActivity {


    @Override
    public BaseFragment getFirstFragment() {
        return MainFragment.newInstance();
    }


    @Override
    protected void handlerIntent(Intent intent) {
        super.handlerIntent(intent);
        //获取传递过来的附带数据
    }

}
