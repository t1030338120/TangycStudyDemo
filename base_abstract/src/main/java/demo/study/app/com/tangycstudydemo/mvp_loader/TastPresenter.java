package demo.study.app.com.tangycstudydemo.mvp_loader;

import demo.study.app.com.tangycstudydemo.mvp_loader.base.BasePresenter;

/**
 * 描述：
 * 作者：tyc
 */
public class TastPresenter extends BasePresenter<TastView> {

    public String getShowData(){
        return "presenter 返回的数据";
    }
}