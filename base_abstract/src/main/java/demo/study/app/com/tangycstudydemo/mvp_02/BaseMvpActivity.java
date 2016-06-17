package demo.study.app.com.tangycstudydemo.mvp_02;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 描述：
 * 作者：tyc
 */
public abstract class BaseMvpActivity<V, T extends BaseMvpPresenter<V>> extends AppCompatActivity{

    protected T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }


    protected abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.dettachView();
    }
}
