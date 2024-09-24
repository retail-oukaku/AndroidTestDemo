package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.annotation.OptIn
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.common.util.Util
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.myapplication.databinding.ActivityPlayerBinding


class PlayerActivity : ComponentActivity() {
    private var player: ExoPlayer? = null
    private lateinit var videoView: PlayerView

    // assetのmp4ファイルの再生機能
    private fun initializePlayer() {
        player = ExoPlayer.Builder(this).build().also {
            exoPlayer ->
//            val mediaItem = MediaItem.fromUri(getString(R.string.media_url_mp3))
            val videoUri = Uri.parse("asset:///BigBuckBunny_320x180.mp4")
            // Build the media item.
            val mediaItem = MediaItem.fromUri(videoUri)
// Set the media item to be played.
            exoPlayer.setMediaItem(mediaItem)
// Prepare the player.
            exoPlayer.prepare()
// Start the playback.
            exoPlayer.play()
        }
        videoView = findViewById(R.id.video_view)

        videoView.player = player
    }

    // httpsのmp4ファイルの再生機能
    private fun initializePlayer1() {
        player = ExoPlayer.Builder(this).build().also {
                exoPlayer ->
//            val mediaItem = MediaItem.fromUri(getString(R.string.media_url_mp3))
            val videoUri = Uri.parse("https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4")
            // Build the media item.
            val mediaItem = MediaItem.fromUri(videoUri)
// Set the media item to be played.
            exoPlayer.setMediaItem(mediaItem)
// Prepare the player.
            exoPlayer.prepare()
// Start the playback.
            exoPlayer.play()
        }
        videoView = findViewById(R.id.video_view)

        videoView.player = player
    }

    // sandboxから取得Mp4の再生
    private fun initializePlayer2() {
        player = ExoPlayer.Builder(this).build().also {
                exoPlayer ->
//            val mediaItem = MediaItem.fromUri(getString(R.string.media_url_mp3))
            val videoUri = Uri.parse("https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4")
            // Build the media item.
            val mediaItem = MediaItem.fromUri(videoUri)
// Set the media item to be played.
            exoPlayer.setMediaItem(mediaItem)
// Prepare the player.
            exoPlayer.prepare()
// Start the playback.
//            exoPlayer.play()
        }
        videoView = findViewById(R.id.video_view)

        videoView.player = player
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 这里将 activity_main.xml 与 MainActivity 绑定
        setContentView(R.layout.activity_player)
    }


    @OptIn(UnstableApi::class)
    public override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) {
            initializePlayer2()
        }
    }

    @OptIn(UnstableApi::class)
    public override fun onResume() {
        super.onResume()
        if ((Util.SDK_INT < 24 || player == null)){
            initializePlayer2()
        }
    }

    @OptIn(UnstableApi::class)
    public override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
    }

    @OptIn(UnstableApi::class)
    public override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }


    @OptIn(UnstableApi::class)
    private fun releasePlayer() {
        player?.run {
            playWhenReady = this.playWhenReady
            release()
        }
        player = null
    }

    // 按钮点击事件触发跳转
    fun playVideo(view: View?) {
        player?.play()
    }
}
