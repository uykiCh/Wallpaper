package com.company.bestever.wallpaper.tools;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.company.bestever.wallpaper.R;

public class ChangeFragment {

    private FragmentActivity activity;

    public void replaceFragment(Fragment fragment, String tag){

        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left);
        fragmentTransaction.add(R.id.main_container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void detachActivity(){
        this.activity = null;//i don't understand will it be thing that save some memory
    }

    public void attachActivity(FragmentActivity activity) {
        this.activity = activity;
    }
}
