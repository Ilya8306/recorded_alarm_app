package com.example.remind_app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi

class myBroadcastReceiver: BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onReceive(context: Context?, intent: Intent?) {
        println("TIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIME1")
        println(intent!!.action)
        if (intent!!.action.equals("alm")){

            val not = Notifications()
            Toast.makeText(context,"fu", Toast.LENGTH_LONG).show()
            val intentService = Intent(context, AlarmService::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context!!.startForegroundService(intentService)
            } else {
                context!!.startService(intentService)
            }
        }
        else if (intent!!.action.equals("android.intent.action.BOOT_COMPLETED")){
            val savedata = SaveData(context!!)
            savedata.setAlarm()
        }

    }

}