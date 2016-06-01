package demo.study.app.com.tangycstudydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import demo.study.app.com.lib_core.BaseActivity;
import demo.study.app.com.lib_core.BaseFragment;


/**
 * 描述：
 * 1、 一个必须实现的抽象方法getFirstFragment()，来获取当前Activity应该显示的第一个Fragment
 * 2、在Activity的onCreate()方法中拿到intent，添加fragment
 *
 * 作者：tyc
 */
public abstract class AppActivity extends BaseActivity {

    //获取当前Activity应该显示的第一个Fragment
    public abstract BaseFragment getFirstFragment();
    protected void handlerIntent(Intent intent) { }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        initView();

        if(null == getIntent()){
            handlerIntent(getIntent());
        }

        if(null == getSupportFragmentManager().getFragments()){
            //获取当前Activity应该显示的第一个Fragment
            BaseFragment firstFragment = getFirstFragment();

            if(null != firstFragment){
                addFragment(firstFragment);
            }
        }
    }



    public void initView(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
    }


    @Override
    public int getContentViewId() {
        return R.layout.activity_app;
    }

    @Override
    public int getFragmentContentId() {
        return R.id.fl_fragment_container;
    }
}
