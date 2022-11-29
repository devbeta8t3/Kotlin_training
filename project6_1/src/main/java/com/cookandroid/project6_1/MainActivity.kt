package com.cookandroid.project6_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.Chronometer
import android.widget.RadioButton
import android.widget.TextView
import android.widget.TimePicker

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "시간 예약"

        var btnStart = findViewById<Button>(R.id.btnStart)
        var btnEnd = findViewById<Button>(R.id.btnEnd)

        var chrono = findViewById<Chronometer>(R.id.chronometer1)

        var rdoCal = findViewById<RadioButton>(R.id.rdoCal)
        var rdoTime = findViewById<RadioButton>(R.id.rdoTime)

        var tPicker = findViewById<TimePicker>(R.id.timePicker1)
        var calView = findViewById<CalendarView>(R.id.calendarView1)

        var tvYear = findViewById<TextView>(R.id.tvYear)
        var tvMonth = findViewById<TextView>(R.id.tvMonth)
        var tvDay = findViewById<TextView>(R.id.tvDay)
        var tvHour = findViewById<TextView>(R.id.tvHour)
        var tvMin = findViewById<TextView>(R.id.tvMin)

        var selectYear : Int = 0
        var selectMonth : Int = 0
        var selectDay : Int = 0

        tPicker.visibility = View.INVISIBLE
        calView.visibility = View.INVISIBLE

        rdoCal.setOnClickListener {
            tPicker.visibility = View.INVISIBLE
            calView.visibility = View.VISIBLE
        }
        rdoTime.setOnClickListener {
            tPicker.visibility = View.VISIBLE
            calView.visibility = View.INVISIBLE
        }

    }
}