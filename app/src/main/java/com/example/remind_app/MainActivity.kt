package com.example.remind_app

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    lateinit var reciver : myBroadcastReceiver
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val savedata = SaveData(applicationContext)
        SetTextTime(savedata.getHour(), savedata.getMin())

        reciver = myBroadcastReceiver()

        var it = IntentFilter()
        it.addAction("alm")
        registerReceiver(reciver,it)
    }

    fun BtnSetTime(view: View){
        val timepupup = timePupup()
        val fm = supportFragmentManager
        timepupup.show(fm, "Select Time")
    }

    fun SetTextTime(Hours:Int, Min:Int){
        var text = findViewById<TextView>(R.id.lbShowTime)
        text.text = Hours.toString() + ":" + Min.toString()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun SetTime(Hours:Int, Min:Int){

        SetTextTime(Hours, Min)

        val savedata = SaveData(applicationContext)
        savedata.saveData(Hours, Min)
        savedata.setAlarm()

    }


    override fun onStop() {
        super.onStop()
        unregisterReceiver(reciver)
    }
}