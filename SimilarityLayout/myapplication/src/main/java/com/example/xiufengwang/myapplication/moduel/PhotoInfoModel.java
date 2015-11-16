package com.example.xiufengwang.myapplication.moduel;

import java.io.Serializable;

/**
 * Created by xiufengwang on 2015/11/12.
 */
public class PhotoInfoModel implements Serializable {
    private static final long serialVersionUID = -7894054787512507062L;

    private int img_id;
    private String path_file;
    private String path_absolute;
    private boolean isChoose;

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public String getPath_file() {
        return path_file;
    }

    public void setPath_file(String path_file) {
        this.path_file = path_file;
    }

    public String getPath_absolute() {
        return path_absolute;
    }

    public void setPath_absolute(String path_absolute) {
        this.path_absolute = path_absolute;
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setIsChoose(boolean isChoose) {
        this.isChoose = isChoose;
    }
}
