package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.ComponentActivity;



public class SecondActivity extends ComponentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 对应xml文件的设置，路径为一下
        setContentView(R.layout.activity_second);  // 设置对应的布局文件
    }

}


