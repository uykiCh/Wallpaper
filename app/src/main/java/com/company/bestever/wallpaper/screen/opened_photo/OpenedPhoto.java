package com.company.bestever.wallpaper.screen.opened_photo;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.company.bestever.wallpaper.R;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

public class OpenedPhoto extends SwipeBackFragment {

    private static final String TAG = "OpenedPhoto";

    private View view;

    private Object photo;

    @BindView(R.id.fragment_opene_photo_main_image)
    protected ImageView mainImage;

    private TextView tvSetWallpaper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {

            view = inflater.inflate(R.layout.fragment_opened_photo, container, false);
            ButterKnife.bind(this, view);

            tvSetWallpaper = view.findViewById(R.id.fragment_opened_photo_btn);

            Log.i(TAG, "Tag is: " + getTag());

            getPhotoFromArguments();

            Glide.with(Objects.requireNonNull(getContext()).getApplicationContext())
                    .asBitmap()
                    .load(photo)
                    .into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                    mainImage.setImageBitmap(resource);
                    setTvSetWallpaperListener(resource);
                }
            });

        }

        return attachToSwipeBack(view);
    }

    private void getPhotoFromArguments() {
        assert getArguments() != null;
        if (getArguments().getString("path") != null) {
            photo = getArguments().getString("path");
        } else {
            photo = getArguments().getInt("path");
        }
    }

    private void setTvSetWallpaperListener(final Bitmap bitmap) {
        tvSetWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvSetWallpaper.setClickable(false);

                Log.i(TAG, "Trying ");
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(Objects.requireNonNull(getContext()).getApplicationContext());

                try {

                    wallpaperManager.setBitmap(bitmap);
                    tvSetWallpaper.setTextColor(Color.parseColor("#BDBDBD"));

                    Toast.makeText(getContext(), "Complete :)", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {

                    Toast.makeText(getContext(), "Error :(", Toast.LENGTH_SHORT).show();

                    Log.i(TAG, "Error ");
                    Log.i(TAG, e.getMessage());

                    tvSetWallpaper.setClickable(false);

                }



            }
        });
    }
}
