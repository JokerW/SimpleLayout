package com.example.xiufengwang.myapplication.view.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.xiufengwang.myapplication.R;
import com.example.xiufengwang.myapplication.view.fragment.PhotoThumbnailFragment;
import com.example.xiufengwang.myapplication.view.widget.PhotoInterface;

public class MainActivity extends AppCompatActivity {

    private PhotoInterface photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.thumbnail_layout, PhotoThumbnailFragment.getInstance()).commit();
    }


}
