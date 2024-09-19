package com.example.myapplication

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // 这里将 activity_main.xml 与 MainActivity 绑定
        setContentView(R.layout.activity_main)
    }

    // 按钮点击事件触发跳转
    fun openSecondActivity(view: View?) {
        val intent = Intent(
            this@MainActivity,
            SecondActivity::class.java
        )
        startActivity(intent)
    }

    // 按钮点击事件触发跳转
    fun openPlayActivity(view: View?) {
//        val intent = Intent(
//            this@MainActivity,
//            PlayerActivity::class.java
//        )
//        startActivity(intent)
        val intent = Intent(
            this@MainActivity,
            PlayerActivity::class.java
        )
        startActivity(intent)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}