package com.example.myapplication

import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.activity.ComponentActivity


class MediaPlayerActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 这里将 activity_player.xml 与 MainActivity 绑定
        setContentView(com.example.myapplication.R.layout.activity_media_player)
        initializePlayer()
    }

    public override fun onStart() {
        super.onStart()

    }

    public override fun onResume() {
        super.onResume()

    }

    public override fun onPause() {
        super.onPause()

    }

    public override fun onStop() {
        super.onStop()

    }

    private var mediaPlayer: MediaPlayer? = MediaPlayer()
//    private lateinit var videoView: PlayerView

    // assetのmp4ファイルの再生機能
    private fun initializePlayer() {
        // 获取AssetManager
        val assetManager = assets
        // 打开assets中的文件
        val descriptor: AssetFileDescriptor = assetManager.openFd("sampleAdVideo.mp4")


        // 设置数据源
        mediaPlayer!!.setDataSource(
            descriptor.fileDescriptor,
            descriptor.startOffset,
            descriptor.length
        )


        // 关闭descriptor
        descriptor.close()

        val surfaceView = findViewById<SurfaceView>(com.example.myapplication.R.id.surfaceView)
        val holder = surfaceView.holder
        holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {
                mediaPlayer?.setDisplay(holder)
            }

            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) {
            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {
            }
        })
        mediaPlayer!!.isLooping = true;
        mediaPlayer!!.prepareAsync()
        mediaPlayer!!.setOnPreparedListener { mediaPlayer!!.start() }
    }






    private fun playMediaPlayer() {

    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer != null) {
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }
}
