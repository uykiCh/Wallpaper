package com.company.bestever.wallpaper.presenter.folders_fragment;

import android.util.Log;

import com.company.bestever.wallpaper.R;
import com.company.bestever.wallpaper.data.App;
import com.company.bestever.wallpaper.data.dao.FolderDAO;
import com.company.bestever.wallpaper.data.dao.PhotoDAO;
import com.company.bestever.wallpaper.data.database.FolderDatabase;
import com.company.bestever.wallpaper.interfaces.ListItem;
import com.company.bestever.wallpaper.model.FolderModel;
import com.company.bestever.wallpaper.model.PhotoModel;
import com.company.bestever.wallpaper.screen.folders_fragment.FoldersFragment;
import java.util.List;
import java.util.Random;

public class FoldersFragmentPresenter {

    private Random random;

    private FoldersFragment foldersFragment;

    private FolderDatabase database;
    private FolderDAO folderDAO;
    private PhotoDAO photoDAO;

    public void attachFoldersFragment(FoldersFragment foldersFragment){
        this.foldersFragment = foldersFragment;
        database = App.getInstance().getDatabase();
        photoDAO = database.photoDAO();
        folderDAO = database.folderDAO();
        random = new Random();
    }

    public void detachFoldersFragment(){
        this.foldersFragment = null;
        this.database = null;
        this.folderDAO = null;
        this.photoDAO = null;
    }

   /* public void imitationFirstOpen(List<ListItem> list){
        list.add(new FolderModel("main", "sheet", R.drawable.lifecycle));
        list.add(new PhotoModel(R.drawable.lifecycle));
        list.add(new FolderModel("main", "name", R.drawable.lifecycle));
    }

    public void imitationEnoughOpen(List<ListItem> list){
        list.add(new FolderModel("main_cars","asd", R.drawable.lifecycle));
        list.add(new PhotoModel(R.drawable.lifecycle));
        list.add(new PhotoModel(R.drawable.lifecycle));
        list.add(new PhotoModel("https://picsum.photos/720/1280/?image=" + random.nextInt(1000)));
        list.add(new PhotoModel("https://picsum.photos/720/1280/?image=" + random.nextInt(1000)));
        list.add(new FolderModel("main_animals","animals", "https://picsum.photos/720/1280/?image=" + random.nextInt(1000)));

    }*/

    public void insertFolder(String folderName, String folderPath, String imageURL, Integer imagePath){

        FolderModel folderModel = new FolderModel();
        folderModel.name = folderName;
        folderModel.folderPath = folderPath;
        folderModel.imageURL = imageURL;
        folderModel.imagePath = imagePath;

        folderDAO.insert(folderModel);

    }

    public List<FolderModel> getAllFoldersByPath(String path){

        return folderDAO.getAll(path);

    }

}
