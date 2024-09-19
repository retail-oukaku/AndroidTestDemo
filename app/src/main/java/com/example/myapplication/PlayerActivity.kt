package com.example.myapplication

import android.os.Bundle
import android.widget.SimpleExpandableListAdapter
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.media3.common.MediaItem
import androidx.media3.common.SimpleBasePlayer
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import com.example.myapplication.databinding.ActivityPlayerBinding
import com.example.myapplication.ui.theme.MyApplicationTheme


class PlayerActivity : ComponentActivity() {
    private var player: ExoPlayer? = null

    // 为了获取页面的某些东西？
    private val viewBinding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityPlayerBinding.inflate(layoutInflater)
    }

    @OptIn(UnstableApi::class)
    private fun initializePlayer() {
        player = ExoPlayer.Builder(this).build().also {
            exoPlayer -> viewBinding.videoView.player = exoPlayer
            val mediaItem = MediaItem.fromUri(getString(R.string.media_url_mp3))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 这里将 activity_main.xml 与 MainActivity 绑定
        setContentView(R.layout.activity_player)
    }

}
