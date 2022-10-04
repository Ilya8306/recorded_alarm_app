package com.example.remind_app

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

class SaveData {
    var context:Context?=null
    constructor(context: Context){
        this.context = context
    }
    @RequiresApi(Build.VERSION_CODES.M)
    fun setAlarm(hour:Int, min:Int){
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, min)
        calendar.set(Calendar.SECOND, 0)

        val am = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        var intent = Intent(context, myBroadcastReceiver::class.java)
        intent.putExtra("message", "alarm time")
        intent.action = "com.tester.alarmmanager"
        val pI = PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_IMMUTABLE)

        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, AlarmManager.INTERVAL_DAY, pI)

    }
}