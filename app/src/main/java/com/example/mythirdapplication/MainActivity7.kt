package com.example.mythirdapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        val startBtn = findViewById<Button>(R.id.startBtn)
        val stopBtn= findViewById<Button>(R.id.stopBtn)

        startBtn.setOnClickListener {
            val intent = Intent(this,ForegroundDemo::class.java)
            // passing data through intent
            intent.putExtra("inputExtra", "Foreground Service is running...")
            ContextCompat.startForegroundService(this, intent)
//            OR
//            startService(intent)
        }
        stopBtn.setOnClickListener {
            stopService(Intent(this,ForegroundDemo::class.java))
        }
    }
}