package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.ComponentActivity;



public class SecondActivity extends ComponentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 对应xml文件的设置，路径为一下
        setContentView(R.layout.activity_second);  // 设置对应的布局文件


        // 获取返回按钮
        Button backButton = findViewById(R.id.button_back);

        // 设置返回按钮的点击事件
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 返回到 MainActivity
                finish();  // 销毁当前 Activity，回到上一个 Activity
            }
        });
    }
}


