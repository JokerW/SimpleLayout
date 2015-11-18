package com.example.xiufengwang.myapplication.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by xiufengwang on 2015/11/18.
 */
public class LibIOUtils {

    private static final String IMAGE = "image";

    public static String getSDCardPath() {
        return Environment.getExternalStorageDirectory().toString();
    }

    public static boolean getExternalStorageState() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public static String getBaseLocalLocation(Context context) {
        boolean isSDCanRead = getExternalStorageState();
        String baseLocation = "";
        if (isSDCanRead) {
            baseLocation = getSDCardPath();
        } else {
            baseLocation = context.getCacheDir().getAbsolutePath();
        }
        return baseLocation;
    }

    public static String getImagePath(Context context) {
        String basePath = getBaseLocalLocation(context);
        String packetPath = context.getPackageName();
        return  basePath + File.separator + packetPath + File.separator + IMAGE + File.separator;
    }



}
