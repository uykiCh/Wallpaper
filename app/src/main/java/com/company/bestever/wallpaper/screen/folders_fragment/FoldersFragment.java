package com.company.bestever.wallpaper.screen.folders_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.bestever.wallpaper.R;
import com.company.bestever.wallpaper.adapter.folder.FolderAdapter;
import com.company.bestever.wallpaper.interfaces.OpenFullElement;
import com.company.bestever.wallpaper.model.FolderModel;
import com.company.bestever.wallpaper.presenter.folders_fragment.FoldersFragmentPresenter;
import com.company.bestever.wallpaper.screen.opened_photo.OpenedPhoto;
import com.company.bestever.wallpaper.tools.ChangeFragment;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

public class FoldersFragment extends Fragment implements OpenFullElement {

    private View view;

    private List<FolderModel> list;
    private RecyclerView recyclerView;
    private FolderAdapter folderAdapter;

    private ChangeFragment changeFragment;
    private FoldersFragmentPresenter foldersFragmentPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setClasses();
        changeFragment.attachActivity(getActivity());
        foldersFragmentPresenter.attachFoldersFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {

            view = inflater.inflate(R.layout.fragment_main, container, false);

            setRV();

            foldersFragmentPresenter.setList();

        }

        return view;
    }

    private void setRV() {

        list = new ArrayList<>();

        recyclerView = view.findViewById(R.id.fragment_main_recycler_view);

        folderAdapter = new FolderAdapter(list, this);

        recyclerView.setAdapter(folderAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext().getApplicationContext(), 2));

    }

    private void setClasses(){

        changeFragment = new ChangeFragment();
        foldersFragmentPresenter = new FoldersFragmentPresenter();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        changeFragment.detachActivity();
        foldersFragmentPresenter.detachFoldersFragment();
    }

    public List<FolderModel> getList() {
        return list;
    }

    @Override
    public void openFull(Integer path) {
        OpenedPhoto openedPhoto = new OpenedPhoto();
        Bundle bundle = new Bundle();
        bundle.putInt("path", path);
        openedPhoto.setArguments(bundle);
        changeFragment.replaceFragment(openedPhoto, "OPENED_PHOTO_PATH_" + path);
    }
}
