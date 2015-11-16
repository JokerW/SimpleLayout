package com.example.xiufengwang.myapplication.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.xiufengwang.myapplication.R;
import com.example.xiufengwang.myapplication.view.widget.FirstView;
import com.example.xiufengwang.myapplication.view.widget.PhotoInterface;

public class MainActivity extends AppCompatActivity {

    private PhotoInterface photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photo = new FirstView(this);

    }
}
