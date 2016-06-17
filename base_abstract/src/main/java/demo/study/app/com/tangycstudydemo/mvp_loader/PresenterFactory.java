package demo.study.app.com.tangycstudydemo.mvp_loader;

public interface PresenterFactory<T extends BasePresenter> {
      T create();
  } 