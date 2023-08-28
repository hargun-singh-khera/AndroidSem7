package com.example.mythirdapplication

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity8 : AppCompatActivity() {
//    var mBoundService: BoundServiceDemo?= null
//    var mServiceBound = false
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main8)
//
//        val timeStampText = findViewById<View>(R.id.timestamp_text) as TextView
//        val printTimeStampBtn: Button = findViewById<View>(R.id.startBtn) as Button
//        val stopServiceBtn: Button= findViewById<View>(R.id.stopBtn) as Button
//
//        printTimeStampBtn.setOnClickListener {
//            if(mServiceBound) {
//                timeStampText.text = mBoundService!!.getTimestamp()
//            }
//        }
//
//        stopServiceBtn.setOnClickListener {
//            if (mServiceBound) {
//                unbindService(mServiceConnection)
//                mServiceBound = false
//            }
//            stopService(Intent(this@MainActivity8, BoundServiceDemo::class.java))
//        }
//        override fun onStart() {
//            super.onStart()
//            val intent = Intent(this,BoundServiceDemo::class.java)
//            startService(intent)
//            bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE)
//        }
//
//        override fun onStop() {
//            super.onStop()
//            if (mServiceBound) {
//                unbindService(mServiceConnection)
//                mServiceBound = false
//            }
//        }
//        val mServiceConnection: ServiceConnection = object : ServiceConnection {
//            override fun onServiceDisconnected(name: ComponentName) {
//                mServiceBound = false
//            }
//
//            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
//                val myBinder: BoundServiceDemo.MyBinder = service as BoundServiceDemo.MyBinder
//                mBoundService = myBinder.getService()
//                mServiceBound = true
//            }
//        }
//    }
}