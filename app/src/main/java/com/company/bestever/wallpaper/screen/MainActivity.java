package com.company.bestever.wallpaper.screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.company.bestever.wallpaper.R;

import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;

public class MainActivity extends SwipeBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSwipeBackEnable(false);

    }

}
