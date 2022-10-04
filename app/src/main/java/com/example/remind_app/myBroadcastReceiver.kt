package com.example.remind_app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class myBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        println("TIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIME1")
        if (intent!!.action.equals("com.tester.alarmmanager")){
            var b=intent.extras
            Toast.makeText(context,b!!.getString("message"),Toast.LENGTH_LONG).show()
        }
    }

}