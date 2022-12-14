package com.example.remind_app

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment

class timePupup:DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var myView = inflater!!.inflate(R.layout.time_pupup, container, false)
        var btnDone = myView.findViewById<Button>(R.id.btnDone)
        var tp1 = myView.findViewById<TimePicker>(R.id.tp1)

        btnDone.setOnClickListener {
            val ma = activity as MainActivity
            if (Build.VERSION.SDK_INT >= 23) {
                ma.SetTime(tp1.hour, tp1.minute)
            }else{
                ma.SetTime(tp1.currentHour, tp1.currentMinute)
            }
            this.dismiss()
        }
        return myView
    }
}