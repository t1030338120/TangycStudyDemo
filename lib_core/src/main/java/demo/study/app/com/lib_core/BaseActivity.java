package demo.study.app.com.lib_core;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

/**
 * 描述：多模块Activity 和 多Fragment的架构
 * 作者：tyc
 */
public abstract class BaseActivity  extends AppCompatActivity {

    //获取Activity布局id
    public abstract int getContentViewId();
    //获取布局中Fragment的id
    public abstract int getFragmentContentId();


    //添加Fragment
    public void addFragment(BaseFragment fragment){
        if(fragment == null) return;

        String className = fragment.getClass().getSimpleName();
        getSupportFragmentManager()
                .beginTransaction().replace(getFragmentContentId(), fragment, className)
                .addToBackStack(className)
                .commitAllowingStateLoss();
    }

    //移除Fragment
    public void removeFragment(){
        if(getSupportFragmentManager().getBackStackEntryCount() > 1){
            getSupportFragmentManager().popBackStack();
        }else {
            finish();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        if(getSupportFragmentManager().getBackStackEntryCount() == 1){
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
