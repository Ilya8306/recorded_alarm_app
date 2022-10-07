package com.example.remind_app

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

class SaveData {
    var context:Context?=null
    var sharedRef: SharedPreferences?=null
    constructor(context: Context){
        this.context = context
        sharedRef = context.getSharedPreferences("myref", Context.MODE_PRIVATE)
    }

    fun saveData(hour: Int, min: Int){
        val editor = sharedRef!!.edit()
        editor.putInt("hour", hour)
        editor.putInt("min", min)
        editor.commit()
    }

    fun getHour():Int{
        return sharedRef!!.getInt("hour", 0)
    }
    fun getMin():Int{
        return sharedRef!!.getInt("min", 0)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun setAlarm(){
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, getHour())
        calendar.set(Calendar.MINUTE, getMin())
        calendar.set(Calendar.SECOND, 0)

        val am = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        var intent = Intent(context, myBroadcastReceiver::class.java)
        intent.putExtra("message", "alarm time")
        intent.action = "alm"

        var pI = PendingIntent.getBroadcast(context,0,intent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)


        am.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pI)

    }
}