package com.example.xiufengwang.myapplication.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiufengwang.myapplication.AlbumAsyncTask;
import com.example.xiufengwang.myapplication.R;
import com.example.xiufengwang.myapplication.moduel.PhotoInfoModel;
import com.example.xiufengwang.myapplication.view.adapter.ThumbnailAdapter;
import com.example.xiufengwang.myapplication.view.widget.AutoHeightGridView;

import java.util.List;

/**
 * Created by xiufengwang on 2015/11/13.
 */
public class PhotoThumbnailFragment extends Fragment {

    private List<PhotoInfoModel> mImageInfoList;
    private AlbumAsyncTask mAsyncTask;
    private AutoHeightGridView mPhotoGridView;
    private ThumbnailAdapter mAdapter;
    private AlbumAsyncTask.AlbumListener mAlbumListener;

    public static PhotoThumbnailFragment getInstance() {
        PhotoThumbnailFragment mFragment = new PhotoThumbnailFragment();
        return mFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thumbnail_fragment_layout, container, false);
        initView();
        return view;
    }

    private void initView() {
        mPhotoGridView = (AutoHeightGridView) getView().findViewById(R.id.thumbnail_grid);
        mAsyncTask = new AlbumAsyncTask(getActivity(), new AlbumAsyncTask.AlbumListener() {
            @Override
            public void onLoadFinish(List<PhotoInfoModel> list) {
                loadThumbnailFinsh(list);
            }
        });
        mAsyncTask.execute();
    }

    private void loadThumbnailFinsh(List<PhotoInfoModel> list) {
        this.mImageInfoList = list;
        mAdapter = new ThumbnailAdapter(getActivity(), mImageInfoList);
        mPhotoGridView.setAdapter(mAdapter);
    }


}
