package com.cookandroid.ch10_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        var btn1 = findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener {
            finish()
        }
    }
}