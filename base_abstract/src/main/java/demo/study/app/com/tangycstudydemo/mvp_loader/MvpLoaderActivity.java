package demo.study.app.com.tangycstudydemo.mvp_loader;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import demo.study.app.com.tangycstudydemo.mvp_loader.base.BaseMvpActivity;
import demo.study.app.com.tangycstudydemo.mvp_loader.base.PresenterFactory;

/**
 * Mvp架构Loader管理presenter的简单demo
 */
public class MvpLoaderActivity extends BaseMvpActivity<TastView, TastPresenter> {

    private TextView mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContentView = (TextView) getContentView();
        setContentView(mContentView);

        mContentView.setText(mPresenter.getShowData());
    }

    public View getContentView(){
        TextView textView = new TextView(this);
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setText("初始值");
        return  textView;
    }


    @Override
    public PresenterFactory<TastPresenter> getPresenterFactory() {
        return new PresenterFactory<TastPresenter>() {
            @Override
            public TastPresenter create() {
                return new TastPresenter();
            }
        };
    }
}
