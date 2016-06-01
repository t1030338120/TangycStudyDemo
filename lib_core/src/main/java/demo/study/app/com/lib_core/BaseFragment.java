package demo.study.app.com.lib_core;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 描述：Fragment基类
 * 作者：tyc
 */
public abstract class BaseFragment extends Fragment {

    public BaseActivity mActivity;

    protected abstract int getLayoutId();

    protected abstract void intView(View view, Bundle savedInstanceState);


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (BaseActivity) context;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        intView(view, savedInstanceState);

        return view;
    }


    public BaseActivity getHolderActivity() {
        return mActivity;
    }

}
