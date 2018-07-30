package com.company.bestever.wallpaper.screen.opened_photo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.company.bestever.wallpaper.R;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

public class OpenedPhoto extends SwipeBackFragment {

    private static final String TAG = "OpenedPhoto";

    private View view;

    private Object photo;

    @BindView(R.id.fragment_opene_photo_main_image)
    protected ImageView mainImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null){

            view = inflater.inflate(R.layout.fragment_opened_photo, container, false);
            ButterKnife.bind(this, view);

            Log.i(TAG, "Tag is: " + getTag());

            assert getArguments() != null;
            if (getArguments().getString("path") != null){
                photo = getArguments().getString("path");
            } else {
                photo = getArguments().getInt("path");
            }

            Glide.with(getContext().getApplicationContext())
                    .load(photo).into(mainImage);

        }

        return attachToSwipeBack(view);
    }
}
