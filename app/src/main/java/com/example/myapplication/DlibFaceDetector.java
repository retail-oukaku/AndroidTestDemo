package com.example.myapplication;

public class DlibFaceDetector {
    static {
        System.loadLibrary("dlib"); // 加载 dlib 共享库
    }

    // 定义原生方法
    public native int[] detectFaces(String imagePath);
}
