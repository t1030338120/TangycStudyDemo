package demo.study.app.com.tangycstudydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import demo.study.app.com.tangycstudydemo.mvp_loader.MvpLoaderActivity;

public class AppMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);
    }


    public void click(View view){
        switch (view.getId()){
            case R.id.button_01:

            case R.id.button_02:

            case R.id.button_03:
                startActivity(new Intent(this, MvpLoaderActivity.class));

                break;
        }
    }



}
