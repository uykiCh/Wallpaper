package com.company.bestever.wallpaper.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.company.bestever.wallpaper.model.FolderModel;

import java.util.List;

@Dao
public interface FolderDAO {

    @Query("SELECT * FROM folders WHERE folderPath = :folderPath")
    List<FolderModel> getAll(String folderPath);

    @Insert
    void insert(FolderModel folderModel);

}
