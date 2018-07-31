package com.company.bestever.wallpaper.data;

import android.app.Application;
import android.arch.persistence.room.Room;
import com.company.bestever.wallpaper.data.database.FolderDatabase;

public class App extends Application {

    public static App instance;

    private FolderDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, FolderDatabase.class, "folders")
                .allowMainThreadQueries()
                .build();

    }

    public static App getInstance() {
        return instance;
    }

    public FolderDatabase getDatabase() {
        return database;
    }

}
