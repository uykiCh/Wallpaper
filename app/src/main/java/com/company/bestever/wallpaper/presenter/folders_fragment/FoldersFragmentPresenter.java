package com.company.bestever.wallpaper.presenter.folders_fragment;

import com.company.bestever.wallpaper.data.App;
import com.company.bestever.wallpaper.data.dao.FolderDAO;
import com.company.bestever.wallpaper.data.dao.PhotoDAO;
import com.company.bestever.wallpaper.data.database.FolderDatabase;
import com.company.bestever.wallpaper.model.FolderModel;
import com.company.bestever.wallpaper.model.PhotoModel;
import com.company.bestever.wallpaper.screen.folders_fragment.FoldersFragment;

import java.util.List;
import java.util.Random;

public class FoldersFragmentPresenter {

    private FoldersFragment foldersFragment;

    private FolderDatabase database;
    private FolderDAO folderDAO;
    private PhotoDAO photoDAO;

    public void attachFoldersFragment(FoldersFragment foldersFragment) {
        this.foldersFragment = foldersFragment;
        setFields();
    }

    public void setFields() {
        database = App.getInstance().getDatabase();
        photoDAO = database.photoDAO();
        folderDAO = database.folderDAO();
    }

    public void detachFoldersFragment() {
        this.foldersFragment = null;
        this.database = null;
        this.folderDAO = null;
        this.photoDAO = null;
    }

    public void insertPhoto(String folderName, String imageURL, Integer imagePath) {

        PhotoModel photoModel = new PhotoModel();
        photoModel.setFolderPath(folderName);
        photoModel.setImagePath(imagePath);
        photoModel.setImageURL(imageURL);

        photoDAO.insert(photoModel);

    }

    public List<PhotoModel> getAllPhotosByPath(String path){

        return photoDAO.getAll(path);

    }

    public void insertFolder(String folderName, String folderPath, String imageURL, Integer imagePath) {

        FolderModel folderModel = new FolderModel();
        folderModel.setName(folderName);
        folderModel.setFolderPath(folderPath);
        folderModel.setImageURL(imageURL);
        folderModel.setImagePath(imagePath);

        folderDAO.insert(folderModel);

    }

    public List<FolderModel> getAllFoldersByPath(String path) {

        return folderDAO.getAll(path);

    }

}
