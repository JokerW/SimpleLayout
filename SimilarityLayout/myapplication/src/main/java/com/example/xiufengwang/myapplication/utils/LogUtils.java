package com.example.xiufengwang.myapplication.utils;

import android.util.Log;

/**
 * Created by xiufengwang on 2015/12/3.
 */
public class LogUtils {

    public static String TAG = "similarity_layout";
    public static boolean DEBUG = true;

    public static void i(String s) {
        if (DEBUG)
            Log.i(TAG, s);
    }

    public static void i(String tag, String s) {
        if (DEBUG)
            Log.i(tag, s);
    }

    public static void v(String s) {
        if (DEBUG)
            Log.v(TAG, s);
    }

    public static void v(String tag, String s) {
        if (DEBUG)
            Log.v(tag, s);
    }

    public static void e(String s) {
        if (DEBUG)
            Log.e(TAG, s);
    }

    public static void e(String tag, String s) {
        if (DEBUG)
            Log.e(tag, s);
    }

    public static void e(Exception e) {
        if (DEBUG)
            Log.e(TAG, e.toString());
    }

    public static void d(String s) {
        if (DEBUG)
            Log.d(TAG, s);
    }

    public static void w(String s) {
        if (DEBUG)
            Log.w(TAG, s);
    }



}
