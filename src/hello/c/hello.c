#include <jni.h>
#include <stdio.h>

JNIEXPORT jstring JNICALL
Java_com_example_demo_HelloSpring_print(JNIEnv *env, jobject obj)
{
    char msg[60] = "Hello C Language with Java!";
    jstring result;

    result = (*env)->NewStringUTF(env, msg);
    return result;
}