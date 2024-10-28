
#include <jni.h>
#include <string>
#include <dlib/image_processing.h>
#include "dlib/include/image_processing.h"
#include "dlib/include/image_io.h"
#include "dlib/include/opencv.h" // 这个头文件用于将dlib图像与OpenCV兼容, 但可以不使用OpenCV的功能
#include "dlib/include/array.h"

extern "C"
JNIEXPORT jstring JNICALL
Java_com_yourpackage_MainActivity_nativeFunction(JNIEnv *env, jobject /* this */) {
    // 在这里调用dlib相关方法
    std::string result = "Dlib function result";
    return env->NewStringUTF(result.c_str());
}



extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_myapplication_MainActivity_yourNativeFunction(JNIEnv *env, jobject thiz) {
    // TODO: implement yourNativeFunction()
}