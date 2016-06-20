package demo.study.app.com.tangycstudydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import demo.study.app.com.tangycstudydemo.base_abstract.activity.MainActivity;
import demo.study.app.com.tangycstudydemo.mvp_loader.MvpLoaderActivity;

public class AppMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);
    }


    public void click(View view){
        switch (view.getId()){
            case R.id.button_01:
                startActivity(new Intent(this, MainActivity.class));

                break;
            case R.id.button_02:

                break;
            case R.id.button_03:
                startActivity(new Intent(this, MvpLoaderActivity.class));

                break;
        }
    }



}
