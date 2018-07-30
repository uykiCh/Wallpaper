package com.company.bestever.wallpaper.screen.folders_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.bestever.wallpaper.R;
import com.company.bestever.wallpaper.adapter.MultiAdapter;
import com.company.bestever.wallpaper.interfaces.ListItem;
import com.company.bestever.wallpaper.interfaces.FromAdapterInteractions;
import com.company.bestever.wallpaper.model.FolderModel;
import com.company.bestever.wallpaper.model.PhotoModel;
import com.company.bestever.wallpaper.presenter.folders_fragment.FoldersFragmentPresenter;
import com.company.bestever.wallpaper.screen.opened_photo.OpenedPhoto;
import com.company.bestever.wallpaper.tools.ChangeFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

public class FoldersFragment extends SwipeBackFragment implements FromAdapterInteractions {

    private static final String TAG = "FoldersFragment";

    private View view;

    private List<ListItem> list;
    private RecyclerView recyclerView;
    private MultiAdapter multiAdapter;

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

            setDemo();

            Log.i(TAG, String.valueOf(foldersFragmentPresenter.getAllFoldersByPath(getTag()).size()));
            Log.i(TAG, "TAG is: " + getTag());

            list.addAll(foldersFragmentPresenter.getAllFoldersByPath(getTag()));
            multiAdapter.notifyDataSetChanged();

        }

        //this is using for consider is this fragment was opened in first time or not
        if (getTag().equals("main")) {

            return view;

        }
        //if getTag().equals("FOLDER_FRAGMENT")
        else {
            return attachToSwipeBack(view);
        }
    }

    private void setDemo() {
        foldersFragmentPresenter.insertFolder("animals", getTag(), "https://picsum.photos/720/1280/?image=" + (new Random()).nextInt(1000), null);
        foldersFragmentPresenter.insertFolder("humans", getTag(), "https://picsum.photos/720/1280/?image=" + (new Random()).nextInt(1000), null);
        foldersFragmentPresenter.insertFolder("zimmer", getTag(), "https://picsum.photos/720/1280/?image=" + (new Random()).nextInt(1000), null);
        foldersFragmentPresenter.insertFolder("room", getTag(), "https://picsum.photos/720/1280/?image=" + (new Random()).nextInt(1000), null);
        foldersFragmentPresenter.insertFolder("animals", getTag(), "https://picsum.photos/720/1280/?image=" + (new Random()).nextInt(1000), null);
    }

    private void setRV() {

        list = new ArrayList<>();

        list.addAll(foldersFragmentPresenter.getAllFoldersByPath(getTag()));

        recyclerView = view.findViewById(R.id.fragment_main_recycler_view);

        multiAdapter = new MultiAdapter(getContext().getApplicationContext(), list, this);

        recyclerView.setAdapter(multiAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext().getApplicationContext(), 2));

    }

    private void setClasses() {

        changeFragment = new ChangeFragment();
        foldersFragmentPresenter = new FoldersFragmentPresenter();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        changeFragment.detachActivity();
        foldersFragmentPresenter.detachFoldersFragment();
    }

    @Override
    public void openFullPhoto(Integer path) {
        OpenedPhoto openedPhoto = new OpenedPhoto();
        Bundle bundle = new Bundle();
        bundle.putInt("path", path);
        openedPhoto.setArguments(bundle);
        changeFragment.replaceFragment(openedPhoto, getTag() + "_" + path);
    }

    @Override
    public void openFullPhoto(String imageURL) {
        OpenedPhoto openedPhoto = new OpenedPhoto();
        Bundle bundle = new Bundle();
        bundle.putString("path", imageURL);
        openedPhoto.setArguments(bundle);
        changeFragment.replaceFragment(openedPhoto, getTag() + "_" + imageURL);
    }

    @Override
    public void openFolder(Long folderId) {
        FoldersFragment foldersFragment = new FoldersFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("folderId", folderId);//id folder
        foldersFragment.setArguments(bundle);
        changeFragment.replaceFragment(foldersFragment, getTag() + "_" + folderId);
    }

}
