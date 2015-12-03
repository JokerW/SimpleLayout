package com.example.xiufengwang.myapplication;

import android.app.Application;
import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

import com.example.xiufengwang.myapplication.utils.LibIOUtils;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;

/**
 * Created by xiufengwang on 2015/11/18.
 */
public class MyApplication extends Application {

    private static MyApplication mApp;
    private int mHeight;
    private int mWidth;


    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        init();
    }

    public static MyApplication getInstance() {
        return mApp;
    }


    private void init() {
        initImageLoader(this);
        initWH();
    }


    public void initImageLoader(Context context) {
        ImageLoaderConfiguration config =
                new ImageLoaderConfiguration.Builder(context)
                        .threadPriority(Thread.NORM_PRIORITY)
                        .denyCacheImageMultipleSizesInMemory()
                        .diskCache(
                                new UnlimitedDiscCache(new File(LibIOUtils.getImagePath(context))))
                                // default
                        .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                        .diskCacheSize(50 * 1024 * 1024) // 50mb
                        .threadPoolSize(5).tasksProcessingOrder(QueueProcessingType.LIFO).build();
        ImageLoader.getInstance().init(config);
    }


    public int getScreenHeight() {
        if (mHeight <= 0) {
            initWH();
        }
        return mHeight;
    }

    public int getScreenWidth() {
        if (mWidth <= 0) {
            initWH();
        }
        return mWidth;
    }

    private void initWH() {
        Display display = ((WindowManager) this.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        this.mHeight = display.getHeight();
        this.mWidth = display.getWidth();
    }

}
