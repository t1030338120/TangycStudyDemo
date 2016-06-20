package demo.study.app.com.tangycstudydemo.mvp_loader;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import demo.study.app.com.tangycstudydemo.R;
import demo.study.app.com.tangycstudydemo.mvp_loader.base.BaseMvpActivity;
import demo.study.app.com.tangycstudydemo.mvp_loader.base.PresenterFactory;

/**
 * Mvp架构Loader管理presenter的简单demo
 */
public class MvpLoaderActivity extends BaseMvpActivity<TastView, TastPresenter> implements TastView{

    private TextView mContentView;

    Handler mHandler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_loader);
        mContentView = (TextView) findViewById(R.id.text_loader_01);


//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mPresenter.getShowData();
//            }
//        }, 1000);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.getShowData();
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

    @Override
    public void setShowData(String value) {
         mContentView.setText(value);
    }
}
