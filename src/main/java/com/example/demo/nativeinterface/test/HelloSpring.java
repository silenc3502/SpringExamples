package com.example.demo.nativeinterface.test;

public class HelloSpring {
    public native String print();

    static {
        System.loadLibrary("hello");
    }
}
