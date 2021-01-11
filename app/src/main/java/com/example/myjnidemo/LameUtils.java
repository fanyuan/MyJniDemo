package com.example.myjnidemo;

import android.util.Log;

public class LameUtils {
    static {
        System.loadLibrary("libmp3lame");
        System.loadLibrary("hello");
    }
    /**
     * wav转换成mp3的本地方法
     *
     * @param wav
     * @param mp3
     */
    public static native void convertmp3(String wav, String mp3);

    /**
     * 获取LAME的版本信息
     *
     * @return
     */
    public static native String getLameVersion();

    /**
     * 设置进度条的进度，提供给C语言调用
     *
     * @param progress
     */
    public static void setConvertProgress(int progress) {
        //pd.setProgress(progress);
        Log.d("ddebug","转换进度为："+ progress);
    }
    /**
     * 转换完成回调，提供给C语言调用
     *
     * @param outPath
     */
    public static void convertFinish(String outPath) {
        //pd.setProgress(progress);
        Log.d("ddebug","convertFinish:"+ outPath);
    }

}
