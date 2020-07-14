#include <jni.h>
#include <stdio.h>

// Java에서 C언어를 연동하기 위한 규칙
// 1. 맨앞에 Java를 적는다.
// 2. 패키지명 단위로 언더바를 붙여서 쭉 적어준다.
// 3. 클래스명을 적는다(언더바 필요)
// 4. 클래스 내에서 활용하려는 매서드를 적어준다(언더바 필요)
JNIEXPORT jstring JNICALL
Java_com_example_demo_nativeinterface_test_HelloSpring_print(JNIEnv *env, jobject obj)
// Java_com_example_demo_HelloSpring_print(JNIEnv *env, jobject obj)
{
    // C 코드의 배열에 문자열을 설정
    char msg[60] = "Hello C Language with Java!";
    // Java와 연동하기 위해 jstring을 사용함(Java와 C가 함께 사용할 수 있는 문자열)
    jstring result;

    // C는 기본적으로 ASCII 코드를 베이스로 동작하는데
    // Java는 UTF(유니코드)를 베이스로 동작하므로 아래와 같은 방식으로 문자열을 설정해야 한다.
    // 자바 관점에서는 "Hello C Language ~~"를 new 했다고 생각됨
    result = (*env)->NewStringUTF(env, msg);
    return result;
}