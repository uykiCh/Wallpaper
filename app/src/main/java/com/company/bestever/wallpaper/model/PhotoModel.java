package com.company.bestever.wallpaper.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.company.bestever.wallpaper.interfaces.ListItem;

@Entity(tableName = "photos")
public class PhotoModel implements ListItem {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public Integer imagePath;
    public String imageURL;
    public String folderPath;

    public PhotoModel() {
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public PhotoModel(String imageURL) {
        this.imageURL = imageURL;
    }

    public Integer getImagePath() {
        return imagePath;
    }

    public void setImagePath(Integer imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public int getListItemType() {
        return ListItem.TYPE_PHOTO;
    }
}
