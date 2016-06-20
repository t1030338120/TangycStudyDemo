package demo.study.app.com.tangycstudydemo.mvp_loader.base;


import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

/**
 * Loader实现Mvp架构的BaseActivity类
 */
public abstract class BaseMvpActivity<V, T extends BasePresenter<V>> extends AppCompatActivity implements LoaderManager.LoaderCallbacks<T> {
    private static final int LOADER_ID = 101;
    protected T mPresenter;

        @Override
        public void onStart() {
            super.onStart();
            if(mPresenter != null){
                mPresenter.attachView((V) this);
            }
        }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初始化代码
        getSupportLoaderManager().initLoader(LOADER_ID, null, this);

    }


    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.dettachView();
        }
        super.onDestroy();
    }

    @Override
    public Loader<T> onCreateLoader(int id, Bundle args) {
        return new BasePresenterLoader<T>(this, getPresenterFactory());
    }

    @Override
    public void onLoadFinished(Loader<T> loader, T data) {

        this.mPresenter = data;
        System.out.println("==============================================");
    }

    @Override
    public void onLoaderReset(Loader<T> loader) {
        mPresenter = null;
    }


    public abstract PresenterFactory<T> getPresenterFactory();

}
