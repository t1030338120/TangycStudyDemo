package demo.study.app.com.tangycstudydemo.mvp_loader.base;

import demo.study.app.com.tangycstudydemo.mvp_loader.base.BasePresenter;

public interface PresenterFactory<T extends BasePresenter> {
      T create();
  } 