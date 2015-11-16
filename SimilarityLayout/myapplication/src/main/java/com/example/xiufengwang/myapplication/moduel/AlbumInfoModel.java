package com.example.xiufengwang.myapplication.moduel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xiufengwang on 2015/11/12.
 * 相册模型
 */
public class AlbumInfoModel implements Serializable {

    private static final long serialVersionUID = 6343154939415057102L;

    private int album_id;
    private String album_file;
    private String album_absolute;
    private String album_name;
    private List<PhotoInfoModel> list;

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_file() {
        return album_file;
    }

    public void setAlbum_file(String album_file) {
        this.album_file = album_file;
    }

    public String getAlbum_absolute() {
        return album_absolute;
    }

    public void setAlbum_absolute(String album_absolute) {
        this.album_absolute = album_absolute;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public List<PhotoInfoModel> getList() {
        return list;
    }

    public void setList(List<PhotoInfoModel> list) {
        this.list = list;
    }
}
