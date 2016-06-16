package demo.study.app.com.tangycstudydemo.mvp_01;

import java.lang.ref.WeakReference;

/**
 * 描述：
 * 作者：tyc
 */
public class MvpBasePresenter<T> {

    public WeakReference<T> mMvpView;

    public void attachView(T mvpView){
        this.mMvpView = new WeakReference<T>(mvpView);
    }


    public void dettachView(){
        this.mMvpView = null;
    }


    public T getView(){
        return mMvpView.get();
    }


}
