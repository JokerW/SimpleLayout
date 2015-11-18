package com.example.xiufengwang.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.MediaStore;

import com.example.xiufengwang.myapplication.moduel.PhotoInfoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiufengwang on 2015/11/12.
 */

public class AlbumAsyncTask extends AsyncTask<Void, Void, Object> {
    private ContentResolver mCResolver;
    private List<PhotoInfoModel> mListImageInfo = new ArrayList<PhotoInfoModel>();
    private AlbumListener mAlbumListener;

    public AlbumAsyncTask(Context context, AlbumListener listener) {
        mCResolver = context.getContentResolver();
        this.mAlbumListener = listener;
    }

    public void setmAlbumListener(AlbumListener listener) {
        this.mAlbumListener = listener;
    }


    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        mAlbumListener.onLoadFinish(mListImageInfo);
    }

    @Override
    protected Object doInBackground(Void... params) {
        String[] projection = {
                MediaStore.Images.Thumbnails._ID,
                MediaStore.Images.Thumbnails.IMAGE_ID,
                MediaStore.Images.Thumbnails.DATA
        };

        Cursor cursor = mCResolver.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, projection, null, null, null);
//        int count = cursor.getColumnCount();
//        mListImageInfo = new ArrayList<PhotoInfoModel>(count);
        PhotoInfoModel photoModel;

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getColumnIndex(MediaStore.Images.Thumbnails._ID);
//                int imageId = cursor.getColumnIndex(MediaStore.Images.Thumbnails.IMAGE_ID);
                int dataId = cursor.getColumnIndex(MediaStore.Images.Thumbnails.DATA);

                photoModel = new PhotoInfoModel();
                int photoId = cursor.getInt(id);
                String path = cursor.getString(dataId);
                photoModel.setImg_id(photoId);
                photoModel.setPath_absolute(path);
                photoModel.setPath_file("file:/" + path);
                mListImageInfo.add(photoModel);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return null;
    }

    public interface AlbumListener {
        void onLoadFinish(List<PhotoInfoModel> list);
    }


}
