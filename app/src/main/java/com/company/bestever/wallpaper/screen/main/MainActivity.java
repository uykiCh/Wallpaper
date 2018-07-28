package com.company.bestever.wallpaper.screen.main;

import android.os.Bundle;
import com.company.bestever.wallpaper.R;
import com.company.bestever.wallpaper.screen.folders_fragment.FoldersFragment;
import com.company.bestever.wallpaper.tools.ChangeFragment;

import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;

public class MainActivity extends SwipeBackActivity {

    private ChangeFragment changeFragment;
    private FoldersFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setClasses();

        changeFragment.attachActivity(this);
        changeFragment.replaceFragment(mainFragment, "MAIN_FRAGMENT");

        setSwipeBackEnable(false);

    }

    private void setClasses(){

        changeFragment = new ChangeFragment();
        mainFragment = new FoldersFragment();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //no things to use detach in changeFragment because this is MAIN activity and this closing this app on any way it will be destroyed
    }
}
