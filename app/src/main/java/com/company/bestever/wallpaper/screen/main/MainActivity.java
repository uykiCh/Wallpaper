package com.company.bestever.wallpaper.screen.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.company.bestever.wallpaper.R;
import com.company.bestever.wallpaper.presenter.folders_fragment.FoldersFragmentPresenter;
import com.company.bestever.wallpaper.screen.folders_fragment.FoldersFragment;
import com.company.bestever.wallpaper.tools.ChangeFragment;

import java.io.File;
import java.util.Random;

import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;

public class MainActivity extends SwipeBackActivity {

    private static final String TAG = "MainActivityScreen";
    final String PREFS_NAME = "MyPrefsFile";

    private SharedPreferences settings;

    private ChangeFragment changeFragment;
    private FoldersFragment mainFragment;

    private FoldersFragmentPresenter foldersFragmentPresenter;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setClasses();

        checkFirstTimeOpened();

        changeFragment.attachActivity(this);
        changeFragment.replaceFragment(mainFragment, "main");

        setSwipeBackEnable(false);

    }

    private void checkFirstTimeOpened() {
        if (settings.getBoolean("my_first_time", true)) {

            setDatabaseDemo();

            Log.i(TAG, "First opened");

            settings.edit().putBoolean("my_first_time", false).apply();
        }
    }

    private void setDatabaseDemo() {

        foldersFragmentPresenter = new FoldersFragmentPresenter();
        random = new Random();

        foldersFragmentPresenter.setFields();

        setDemo();

    }

    private void setClasses(){

        changeFragment = new ChangeFragment();
        mainFragment = new FoldersFragment();

        settings = getSharedPreferences(PREFS_NAME, 0);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //no things to use detach in changeFragment because this is MAIN activity and this closing this app on any way it will be destroyed
    }

     private void setDemo() {
        //main folders
        foldersFragmentPresenter.insertFolder("Dogs", "main", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);
        foldersFragmentPresenter.insertFolder("Cats", "main", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);
        foldersFragmentPresenter.insertFolder("Birds", "main", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);
        foldersFragmentPresenter.insertFolder("Breads", "main", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);
        foldersFragmentPresenter.insertFolder("Monkeys", "main", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);

         //lazy input folders
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                foldersFragmentPresenter.insertFolder("test" + String.valueOf(i) + String.valueOf(j),"main_" + i, "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);
            }
        }

        //lazy input photos
         for (int i = 1; i < 6; i++) {
             foldersFragmentPresenter.insertPhoto("main_1_6", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);
             foldersFragmentPresenter.insertPhoto("main_1_7", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);
             foldersFragmentPresenter.insertPhoto("main_1_8", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);
             foldersFragmentPresenter.insertPhoto("main_2_9", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);
             foldersFragmentPresenter.insertPhoto("main_2_10", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);
             foldersFragmentPresenter.insertPhoto("main_2_11", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);
             foldersFragmentPresenter.insertPhoto("main_3_12", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);
             foldersFragmentPresenter.insertPhoto("main_3_13", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);
             foldersFragmentPresenter.insertPhoto("main_3_14", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);
         }

         for (int i = 1; i < 6; i++) {

             for (int j = 0; j < 10; j++) {

                 foldersFragmentPresenter.insertPhoto("main_"+i, "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);

             }

         }

         for (int i = 0; i < 10; i++) {

             foldersFragmentPresenter.insertPhoto("main", "https://picsum.photos/1080/1920/?image=" + random.nextInt(1000), null);

         }

    }
}
