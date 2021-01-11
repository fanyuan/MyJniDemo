package com.example.myjnidemo;

public class SayHello {
    static {
        System.loadLibrary("hello");
    }
    public static native String sayHello();
    public static String getStr(String str){
        return  str + "___demo";
    }
}
