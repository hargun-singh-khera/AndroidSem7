package com.example.mythirdapplication

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import android.widget.Chronometer
import android.widget.Toast

class BoundServiceDemo: Service() {
    private val LOG_TAG = "BoundService"
    private val mBinder: IBinder = MyBinder()
    private var mChronometer: Chronometer?=null
    override fun onCreate() {
        super.onCreate()
        Log.v(LOG_TAG,"in onCreate")
        mChronometer = Chronometer(this)
        // used to set the starting point for the Chronometer to the current real time -> chronometer will start counting from the moment it is set
        mChronometer!!.setBase(SystemClock.elapsedRealtime())
        mChronometer!!.start()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return mBinder
    }

    override fun onRebind(intent: Intent?) {
        Log.v(LOG_TAG,"in onRebind")
        super.onRebind(intent)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.v(LOG_TAG, "in onUnbind")
        return true
    }

    // gets called when all the clients gets unbind to the service
    override fun onDestroy() {
        super.onDestroy()
        Log.v(LOG_TAG, "in onDestroy")
        mChronometer!!.stop()
    }

    fun getTimestamp(): String? {
        // subtraction calculates the difference between the current real time and the starting time of the Chronometer
        val elapsedMillis = (SystemClock.elapsedRealtime() - mChronometer!!.base)
        val hours = (elapsedMillis / 3600000).toInt()
        val minutes = (elapsedMillis - hours * 3600000).toInt() / 60000
        val seconds = (elapsedMillis - hours * 3600000 - minutes * 60000).toInt() / 1000
        val millis = (elapsedMillis - hours * 3600000 - minutes * 60000 - seconds * 1000).toInt()
        return "$hours:$minutes:$seconds:$millis"
    }

    inner class MyBinder: Binder(){
        fun getService(): BoundServiceDemo {
            return this@BoundServiceDemo
        }
    }
}