package demo.study.app.com.tangycstudydemo.mvp_02;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * 描述：mvp presenter的基类。 通过弱引用来解决presenter持有Activity或Fragment对象可能引起的内存泄露。
 * 作者：tyc
 */
public class BaseMvpPresenter<T> {

    public Reference<T> mViewRef;

    public void attachView(T view){
        this.mViewRef = new WeakReference<T>(view);
    }


    public void dettachView(){
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }


    public T getView(){
        return mViewRef.get();
    }



    public boolean isViewAttached(){
        return mViewRef != null && mViewRef.get() != null;
    }



}
