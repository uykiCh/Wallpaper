package com.company.bestever.wallpaper.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.company.bestever.wallpaper.data.dao.FolderDAO;
import com.company.bestever.wallpaper.data.dao.PhotoDAO;
import com.company.bestever.wallpaper.model.FolderModel;
import com.company.bestever.wallpaper.model.PhotoModel;

@Database(entities = {FolderModel.class, PhotoModel.class}, version = 1, exportSchema = false)
public abstract class FolderDatabase extends RoomDatabase{
    public abstract FolderDAO folderDAO();
    public abstract PhotoDAO photoDAO();
}
