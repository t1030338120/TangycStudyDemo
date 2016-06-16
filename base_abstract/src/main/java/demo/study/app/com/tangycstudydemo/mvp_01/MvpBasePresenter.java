package demo.study.app.com.tangycstudydemo.mvp_01;

import java.lang.ref.WeakReference;

/**
 * 描述：
 * 作者：tyc
 */
public class MvpBasePresenter<T> {

    public WeakReference<T> currentView;

    public void attachView(T view){
        this.currentView = new WeakReference<T>(view);
    }


    public void dettachView(){
        this.currentView = null;
    }


    public T getView(){
        return currentView.get();
    }


}
