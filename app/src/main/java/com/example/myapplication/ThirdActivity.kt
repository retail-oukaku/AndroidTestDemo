package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

class ThirdActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third);
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragmentContainer, ThirdFragment())
//                .commit()
//        }

        // 获取返回按钮
        val backButton = findViewById<Button>(R.id.button_back)

        // 设置返回按钮的点击事件
        backButton.setOnClickListener {
            // 返回到 MainActivity
            finish() // 销毁当前 Activity，回到上一个 Activity
        }
    }


    fun red(v: View?) {
        //把fragement01的界面显示在布局文件中

        //1: 先拿到fragement

        val fragement01 = Fragment01()

        //2:获取fragement管理器
        val fManager: FragmentManager = supportFragmentManager;

        //3:打开事物
        val ft = fManager.beginTransaction()

        //4:把内容显示到界面
        ft.replace(R.id.fl, fragement01)

        //5:提交
        ft.commit()
    }

    fun green(v: View?) {
        //把fragement02的界面显示在布局文件中

        //1: 先拿到fragement

        val fragement02 = Fragment02()

        //2:获取fragement管理器
        val fManager: FragmentManager = supportFragmentManager

        //3:打开事物
        val ft = fManager.beginTransaction()

        //4:把内容显示到界面
        ft.replace(R.id.fl, fragement02)

        //5:提交
        ft.commit()
    }

    fun blue(v: View?) {
        //把fragement03的界面显示在布局文件中

        //1: 先拿到fragement

        val fragement03 = Fragment03()

        //2:获取fragement管理器
        val fManager: FragmentManager = supportFragmentManager

        //3:打开事物
        val ft = fManager.beginTransaction()

        //4:把内容显示到界面
        ft.replace(R.id.fl, fragement03)

        //5:提交
        ft.commit()
    }

    // 切换到 FragmentB
//    fun switchToFragmentB() {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, FragmentB())
//            .addToBackStack(null) // 添加到返回栈，支持返回操作
//            .commit()
//    }
}
