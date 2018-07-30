package com.company.bestever.wallpaper.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.company.bestever.wallpaper.interfaces.ListItem;

@Entity(tableName = "folders")
public  class FolderModel implements ListItem{

    @PrimaryKey(autoGenerate = true)
    public Long id;

    public Integer imagePath;
    public String imageURL;
    public String folderPath;

    public String name;

    public FolderModel() {
    }

    @Ignore
    public FolderModel(String folderPath, String name, Integer imagePath) {
        this.folderPath = folderPath;
        this.name = name;
        this.imagePath = imagePath;
    }
    @Ignore
    public FolderModel(String folderPath, String name, String imageURL) {
        this.folderPath = folderPath;
        this.name = name;
        this.imageURL = imageURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    @Override
    public int getListItemType() {
        return ListItem.TYPE_FOLDER;
    }
}
