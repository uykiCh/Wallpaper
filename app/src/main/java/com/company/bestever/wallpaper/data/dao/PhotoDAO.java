package com.company.bestever.wallpaper.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.company.bestever.wallpaper.model.PhotoModel;

import java.util.List;

@Dao
public interface PhotoDAO {

    @Query("SELECT * FROM photos WHERE folderPath = :folderPath")
    List<PhotoModel> getAll(String folderPath);

    @Insert
    void insert(PhotoModel photoModel);

}
