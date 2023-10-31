package com.example.mythirdapplication

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class MainActivity13 : AppCompatActivity() {
    var simpleVideoView: VideoView ?= null
    lateinit var mediaControls: MediaController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main13)

        simpleVideoView = findViewById<View>(R.id.videoView) as VideoView
        mediaControls = MediaController(this@MainActivity13)
        if (mediaControls == null) {
            mediaControls.setAnchorView(simpleVideoView)
        }

        simpleVideoView!!.setMediaController(mediaControls)
        simpleVideoView!!.setZOrderMediaOverlay(true)
        simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.video1))
        simpleVideoView!!.requestFocus()
        simpleVideoView!!.setZOrderOnTop(false)
        simpleVideoView!!.start()

        simpleVideoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "Thank You...", Toast.LENGTH_SHORT).show()
        }
    }
}