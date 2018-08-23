package com.example.administrator.sampleactionbar01;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ActionBar abar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abar = this.getSupportActionBar();

        abar.setSubtitle("옵션바 살펴보기");

        textView = (TextView) findViewById(R.id.textView);
    }


    public void onButton1Clicked(View v) {
        abar.setLogo(R.drawable.home);
        abar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_USE_LOGO);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_refresh:
                textView.setText("새로고침 메뉴가 선택되었습니다.");
                return true;

            case R.id.menu_search:
                textView.setText("검색 메뉴가 선택되었습니다.");
                return true;

            case R.id.menu_settings:
                textView.setText("설정 메뉴가 선택되었습니다.");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
