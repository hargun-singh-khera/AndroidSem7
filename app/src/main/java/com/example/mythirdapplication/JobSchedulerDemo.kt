package com.example.mythirdapplication

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.util.Log
import android.widget.Toast

class JobSchedulerDemo: JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        Log.d("TAG", "onStartJob:")
        val intent = Intent(this@JobSchedulerDemo, BroadCastRecieverDemo::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 234, intent,
            PendingIntent.FLAG_IMMUTABLE)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent)
        Toast.makeText(this@JobSchedulerDemo, "Alarm set", Toast.LENGTH_LONG).show()
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("TAG", "onStopJob:")
        return true
    }
}