package com.company.bestever.wallpaper.adapter.folder;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.company.bestever.wallpaper.R;
import com.company.bestever.wallpaper.interfaces.OpenFullElement;
import com.company.bestever.wallpaper.model.FolderModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.blurry.Blurry;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ViewHolder> {

    private Context context;
    private List<FolderModel> list;

    private OpenFullElement openFullElement;

    public FolderAdapter(List<FolderModel> list, OpenFullElement openFullElement) {
        this.list = list;
        this.openFullElement = openFullElement;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_folder, parent, false);
        context = parent.getContext();

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        /*Blurry.with(context.getApplicationContext()).capture(holder.mView).into(holder.blurView);*/

        final Integer imagePath = list.get(position).getPreviewPath();
        String name = list.get(position).getName();

        holder.setImageView(imagePath);
        holder.setTextView(name);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFullElement.openFull(imagePath);
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_folder_main_image_view)
        protected ImageView imageView;

        /*@BindView(R.id.item_folder_blur_view)
        protected ImageView blurView;*/

        @BindView(R.id.item_folder_name)
        protected TextView textView;

        private View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            ButterKnife.bind(this, mView);
        }

        public void setImageView(Integer path){
            imageView.setBackgroundResource(path);
        }

        public void setTextView(String str){
            textView.setText(str);
        }

    }
}
