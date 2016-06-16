package demo.study.app.com.tangycstudydemo.mvp_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 描述：
 * 作者：tyc
 */
public abstract class MvpBaseActivity <V, T extends MvpBasePresenter<V>>extends AppCompatActivity {

    T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handlerIntent();
        setContentView(getContentViewId());

        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }


    protected abstract T createPresenter();

    protected abstract int getContentViewId();

    protected void handlerIntent() { }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.dettachView();
    }
}
