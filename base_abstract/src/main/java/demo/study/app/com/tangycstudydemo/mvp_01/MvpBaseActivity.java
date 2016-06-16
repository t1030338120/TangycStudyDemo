package demo.study.app.com.tangycstudydemo.mvp_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 描述：
 * 作者：tyc
 */
public abstract class MvpBaseActivity extends AppCompatActivity {

    MvpBasePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handlerIntent();
        setContentView(getContentViewId());

        mPresenter = createPresenter();
        mPresenter.attachView(this);
    }


    protected abstract MvpBasePresenter createPresenter();

    protected abstract int getContentViewId();

    protected void handlerIntent() { }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.dettachView();
    }
}
