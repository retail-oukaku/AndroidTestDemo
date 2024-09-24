package com.example.myapplication

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.annotation.OptIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.util.UnstableApi
import androidx.media3.common.util.Util
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.myapplication.ui.theme.MyApplicationTheme

class MediaPlayerActivity : ComponentActivity() {
    private lateinit var player: ExoPlayer
    private lateinit var playerView: PlayerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_media_player)
        initializePlayerAlso()

    }

    private fun initializePlayer() {
        playerView = findViewById(R.id.play_view)

        // Create an ExoPlayer instance
        player = ExoPlayer.Builder(this).build()

        playerView.player = player
        // create a media item.
        val mediaItem = MediaItem.Builder()
            .setUri("https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4")
            .setMimeType(MimeTypes.APPLICATION_MP4)
            .build()
// Set the media item to be played.
        player.setMediaItem(mediaItem)
// Prepare the player.
        player.prepare()
// Start the playback.
        player.play()
    }

    private fun initializePlayerAlso() {
        playerView = findViewById(R.id.play_view)

        // Create an ExoPlayer instance
        player = ExoPlayer.Builder(this).build()
        // create a media item.
        val videoUri = Uri.parse("assets:///oceans.mp4")
        // Build the media item.
        val mediaItem = MediaItem.fromUri(videoUri)
// Set the media item to be played.
        player.setMediaItem(mediaItem)
        playerView.player = player
// Prepare the player.
        player.prepare()
// Start the playback.
        player.play()
    }


    private fun initializePlayer1() {
        playerView = findViewById(R.id.play_view)

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
        playerView.player = player
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
        player.run {
            release()
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyApplicationTheme {
        Greeting2("Android")
    }
}