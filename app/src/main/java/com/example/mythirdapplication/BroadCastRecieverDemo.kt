package com.example.mythirdapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast

class BroadCastRecieverDemo: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var mp = MediaPlayer.create(context, R.raw.alarm)
        Log.d("Hello", "repeating alarm")
        mp.start()
        Toast.makeText(context, "Message", Toast.LENGTH_SHORT).show()
    }
}