package com.company.bestever.wallpaper.model;

public class FolderModel {

    private String name;
    private Integer previewPath;

    public FolderModel(String name, Integer previewPath) {
        this.name = name;
        this.previewPath = previewPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPreviewPath() {
        return previewPath;
    }

    public void setPreviewPath(Integer previewPath) {
        this.previewPath = previewPath;
    }
}
