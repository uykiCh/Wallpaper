package com.company.bestever.wallpaper.presenter.folders_fragment;

import com.company.bestever.wallpaper.R;
import com.company.bestever.wallpaper.model.FolderModel;
import com.company.bestever.wallpaper.screen.folders_fragment.FoldersFragment;
import java.util.List;

public class FoldersFragmentPresenter {

    private FoldersFragment foldersFragment;

    public void attachFoldersFragment(FoldersFragment foldersFragment){
        this.foldersFragment = foldersFragment;
    }

    public void detachFoldersFragment(){
        this.foldersFragment = null;
    }

    public void setList(){

        List<FolderModel> list = foldersFragment.getList();

        for (int i = 0; i < 5; i++) {
            list.add(new FolderModel("wow", R.drawable.lifecycle));
        }

    }

}
