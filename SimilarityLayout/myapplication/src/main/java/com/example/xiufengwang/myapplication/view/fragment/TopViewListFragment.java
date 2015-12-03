package com.example.xiufengwang.myapplication.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiufengwang.myapplication.R;

/**
 * Created by xiufengwang on 2015/11/16.
 */
public class TopViewListFragment extends Fragment {


    public static TopViewListFragment getInstance() {
        TopViewListFragment mTopFrament = new TopViewListFragment();
        return mTopFrament;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void init() {

    }

}
