package demo.study.app.com.tangycstudydemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import demo.study.app.com.tangycstudydemo.R;
import demo.study.app.com.tangycstudydemo.fragment.ContactFragment;
import demo.study.app.com.tangycstudydemo.fragment.MoreFragment;
import demo.study.app.com.tangycstudydemo.fragment.MsgFragment;


/**
 * 描述：
 * 同级式Fragment在内存不足导致的异常情况下，会出现重叠现象
 */
public class SencondActivity extends AppCompatActivity {

    private static final String KEY_INDEX = "key_index";
    private  String currIndex = "name";

    MsgFragment mMsgFragment;
    ContactFragment mContactFragment;
    MoreFragment mMoreFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mulit_fragment);



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
                    .add(R.id.rl_fragment_container, mMsgFragment, MsgFragment.class.getSimpleName())
                    .add(R.id.rl_fragment_container, mContactFragment, MsgFragment.class.getSimpleName())
                    .add(R.id.rl_fragment_container, mMoreFragment, MsgFragment.class.getSimpleName())
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
