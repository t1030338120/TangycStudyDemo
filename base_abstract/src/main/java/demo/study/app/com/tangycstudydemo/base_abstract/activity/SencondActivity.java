package demo.study.app.com.tangycstudydemo.base_abstract.activity;

import android.os.Bundle;

import demo.study.app.com.lib_core.BaseFragment;
import demo.study.app.com.tangycstudydemo.base_abstract.AppActivity;
import demo.study.app.com.tangycstudydemo.base_abstract.fragment.ContactFragment;
import demo.study.app.com.tangycstudydemo.base_abstract.fragment.MoreFragment;
import demo.study.app.com.tangycstudydemo.base_abstract.fragment.MsgFragment;


/**
 * 描述：同级下多个Fragment在内存不足导致的异常情况下，会出现重叠现象
 */
public class SencondActivity extends AppActivity {

    private static final String KEY_INDEX = "key_index";
    private  String currIndex = "name";

    MsgFragment mMsgFragment;
    ContactFragment mContactFragment;
    MoreFragment mMoreFragment;


    @Override
    public BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(savedInstanceState != null){ //内存重启，调用
            mMsgFragment = (MsgFragment) getSupportFragmentManager().findFragmentByTag(MsgFragment.class.getSimpleName());
            mContactFragment = (ContactFragment) getSupportFragmentManager().findFragmentByTag(ContactFragment.class.getSimpleName());
            mMoreFragment = (MoreFragment) getSupportFragmentManager().findFragmentByTag(MoreFragment.class.getSimpleName());

            currIndex = savedInstanceState.getString(KEY_INDEX);
            //根据下标判断离开时时哪个Fragment显示，
            //这里省略判断，假设离开时是 MsgFragment显示
            //解决重叠问题
            getSupportFragmentManager()
                    .beginTransaction()
                    .show(mMsgFragment)
                    .hide(mContactFragment)
                    .hide(mMoreFragment)
                    .commitAllowingStateLoss();

        }else {

            mMsgFragment = MsgFragment.newInstance();
            mContactFragment = ContactFragment.newInstance();
            mMoreFragment = MoreFragment.newInstance();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(getFragmentContentId(), mMsgFragment, MsgFragment.class.getSimpleName())
                    .add(getFragmentContentId(), mContactFragment, MsgFragment.class.getSimpleName())
                    .add(getFragmentContentId(), mMoreFragment, MsgFragment.class.getSimpleName())
                    .show(mMsgFragment)
                    .hide(mContactFragment)
                    .hide(mMoreFragment)
                    .commitAllowingStateLoss();
        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_INDEX, currIndex);
    }

}
