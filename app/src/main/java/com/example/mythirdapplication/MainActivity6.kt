package com.example.mythirdapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val startBtn = findViewById<Button>(R.id.startBtn)
        val stopBtn= findViewById<Button>(R.id.stopBtn)

        startBtn.setOnClickListener {
            startService(Intent(this,UnboundServiceDemo::class.java))
        }
        stopBtn.setOnClickListener {
            stopService(Intent(this,UnboundServiceDemo::class.java))
        }
    }
}