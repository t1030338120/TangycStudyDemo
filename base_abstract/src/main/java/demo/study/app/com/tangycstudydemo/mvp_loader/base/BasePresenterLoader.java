package demo.study.app.com.tangycstudydemo.mvp_loader.base;

import android.content.Context;
import android.support.v4.content.Loader;

/**
 * 描述：通过Loader延长Presenter生命周期
 * 作者：tyc
 */
public class BasePresenterLoader<T extends BasePresenter> extends Loader<T> {

    private PresenterFactory<T> factory;
    private T presenter;

    public BasePresenterLoader(Context context, PresenterFactory<T> presenterFactory) {
        super(context);
        this.factory = presenterFactory;
    }


    @Override
    protected void onForceLoad() {
        super.onForceLoad();

        // 通过工厂来实例化Presenter
        presenter = factory.create();

        // 返回Presenter
        deliverResult(presenter);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        // 如果已经有Presenter实例那就直接返回
        if (presenter != null) {
            deliverResult(presenter);
            return;
        }

        // 如果没有
        forceLoad();
    }

    @Override
    protected void onReset() {
        super.onReset();
        presenter.dettachView();
        presenter = null;
    }
}
