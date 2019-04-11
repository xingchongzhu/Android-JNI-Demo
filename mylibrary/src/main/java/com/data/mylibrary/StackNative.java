package com.data.mylibrary;

import android.graphics.Bitmap;

public class StackNative {
    /**
     * Load genius jni file
     */
    static {
        System.loadLibrary("jni_blur");
    }

    /**
     * Blur Image By Pixels
     *
     * @param img Img pixel array
     * @param w   Img width
     * @param h   Img height
     * @param r   Blur radius
     */
    public static native void blurPixels(int[] img, int w, int h, int r);

    /**
     * Blur Image By Bitmap
     *s
     * @param bitmap Img Bitmap
     * @param r      Blur radius
     */
    public static native void blurBitmap(Bitmap bitmap, int r);
}
