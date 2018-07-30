package com.company.bestever.wallpaper.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.company.bestever.wallpaper.R;
import com.company.bestever.wallpaper.interfaces.FromAdapterInteractions;
import com.company.bestever.wallpaper.model.FolderModel;

import java.io.File;
import java.util.List;

import com.company.bestever.wallpaper.interfaces.ListItem;
import com.company.bestever.wallpaper.model.PhotoModel;


public class MultiAdapter extends RecyclerView.Adapter<MultiAdapter.ViewHolder> {

    private final Context mContext;
    private final List<ListItem> mItems;
    private final FromAdapterInteractions mOpenFullElement;

    public MultiAdapter(Context ctx, List<ListItem> items, FromAdapterInteractions openFullElement) {
        mContext = ctx;
        mItems = items;
        mOpenFullElement = openFullElement;
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getListItemType();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        View view = null;
        switch (type) {
            case ListItem.TYPE_PHOTO:
                view = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(R.layout.item_multi_adapter_photo, viewGroup, false);
                return new ViewHolderPhoto(view);
            case ListItem.TYPE_FOLDER:
                view = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(R.layout.item_multi_adapter_folder, viewGroup, false);
                return new ViewHolderFolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int pos) {
        ListItem item = mItems.get(pos);
        viewHolder.bindType(item);
        viewHolder.setImage(item);
    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public abstract class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void bindType(ListItem item);

        public abstract void setImage(ListItem item);
    }

    public class ViewHolderPhoto extends ViewHolder {

        private final ImageView mImageView;

        public ViewHolderPhoto(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.item_multi_adapter_photo_main_image_view);

        }

        public void bindType(final ListItem item) {

            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (((PhotoModel) item).getImageURL() != null)

                        mOpenFullElement.openFullPhoto(((PhotoModel) item).getImageURL());

                    else {

                        mOpenFullElement.openFullPhoto(((PhotoModel) item).getImagePath());

                    }
                }
            });

        }

        @Override
        public void setImage(final ListItem item) {
            if (((PhotoModel) item).getImageURL() != null) {

                Glide.with(mContext.getApplicationContext()).load(((PhotoModel) item).getImageURL()).into(mImageView);

            } else {

                Glide.with(mContext.getApplicationContext()).load(((PhotoModel) item).getImagePath()).into(mImageView);

            }
        }
    }

    public class ViewHolderFolder extends ViewHolder {

        private final ImageView mImageView;
        private final TextView mTextView;

        public ViewHolderFolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.item_multi_adapter_folder_name);
            mImageView = (ImageView) itemView.findViewById(R.id.item_multi_adapter_folder_main_image_view);

        }

        public void bindType(final ListItem item) {

            mTextView.setText(((FolderModel) item).getName());

            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mOpenFullElement.openFolder(((FolderModel) item).getId());

                }
            });

        }

        @Override
        public void setImage(final ListItem item) {
            if (((FolderModel) item).getImageURL() != null) {

                Glide.with(mContext.getApplicationContext()).load(((FolderModel) item).getImageURL()).into(mImageView);

            } else {

                Glide.with(mContext.getApplicationContext()).load(((FolderModel) item).getImagePath()).into(mImageView);

            }
        }
    }

}
