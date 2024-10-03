package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.FileDownloadTask
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


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
        val intent = Intent(
            this@MainActivity,
            PlayerActivity::class.java
        )
        startActivity(intent)
    }

    // save oceans.mp4 in sandbox for test
    fun saveFileInSandbox(view: View?) {
        copyAssetToInternalStorage(this, assetFileName = "oceans.mp4")
    }

    // GCSからダウンロード機能
    fun downloadFile(view: View?) {
        val storage: FirebaseStorage = FirebaseStorage.getInstance()
        val storageRef: StorageReference = storage.getReference()
        // 何のpath？
        val fileRef: StorageReference = storageRef.child("path/to/file.jpg")

        val localFile = File.createTempFile("images", "jpg")
        fileRef.getFile(localFile)
            .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot?> {
                // ファイルのダウンロードが成功
            }).addOnFailureListener(OnFailureListener {
                // エラー処理
            })
    }

    private fun copyAssetToInternalStorage(context: Context, assetFileName: String): File {
        val file = File(context.filesDir, assetFileName)

        try {
            context.assets.open(assetFileName).use { inputStream ->
                FileOutputStream(file).use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return file
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