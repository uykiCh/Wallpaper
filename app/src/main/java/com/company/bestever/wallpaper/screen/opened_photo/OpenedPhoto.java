package com.company.bestever.wallpaper.screen.opened_photo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.bestever.wallpaper.R;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

public class OpenedPhoto extends SwipeBackFragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null){
            view = inflater.inflate(R.layout.fragment_opened_photo, container, false);
        }
        return attachToSwipeBack(view);
    }
}
