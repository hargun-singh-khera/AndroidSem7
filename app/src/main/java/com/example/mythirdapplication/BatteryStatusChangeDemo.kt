package com.example.mythirdapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.widget.Toast

class BatteryStatusChangeDemo: BroadcastReceiver() {
    lateinit var msgString: String
    override fun onReceive(context: Context?, intent: Intent?) {
        val percentage = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
        msgString = "Battery Percentage : " + percentage + "%\n"
        val status = intent?.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
//        val isCharging =
//            status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL
//        OR
        val isCharging = when(status) {
            BatteryManager.BATTERY_STATUS_CHARGING -> true
            BatteryManager.BATTERY_STATUS_FULL -> true
            else -> false
        }
        if (isCharging) {
            msgString += "Charging Status: Charging"
        }else {
            msgString += "Charging Status: Not Charging"
        }
        Toast.makeText(context,msgString, Toast.LENGTH_SHORT).show()
    }
}