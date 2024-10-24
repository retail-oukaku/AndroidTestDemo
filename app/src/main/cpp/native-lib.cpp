#include <jni.h>
#include <string>
#include <dlib/image_processing/frontal_face_detector.h>
#include <dlib/image_io.h>

extern "C"
JNIEXPORT jintArray JNICALL
Java_com_example_DlibFaceDetector_detectFaces(JNIEnv* env, jobject instance, jstring imagePath) {
    const char* path = env->GetStringUTFChars(imagePath, 0);

    // 初始化 dlib 人脸检测器
    dlib::frontal_face_detector detector = dlib::get_frontal_face_detector();
    dlib::array2d<dlib::rgb_pixel> img;

    // 读取图像
    dlib::load_image(img, path);

    // 人脸检测
    std::vector<dlib::rectangle> faces = detector(img);

    // 准备返回检测结果
    jintArray result = env->NewIntArray(faces.size() * 4);
    jint* resultArray = new jint[faces.size() * 4];

    for (int i = 0; i < faces.size(); ++i) {
        resultArray[i * 4] = faces[i].left();
        resultArray[i * 4 + 1] = faces[i].top();
        resultArray[i * 4 + 2] = faces[i].right();
        resultArray[i * 4 + 3] = faces[i].bottom();
    }

    env->SetIntArrayRegion(result, 0, faces.size() * 4, resultArray);
    delete[] resultArray;
    env->ReleaseStringUTFChars(imagePath, path);

    return result;
}
