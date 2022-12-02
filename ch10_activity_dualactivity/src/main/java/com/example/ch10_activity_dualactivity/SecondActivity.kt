package com.example.ch10_activity_dualactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "Second 액티비티"

        var inIntent = intent
        var num1 = inIntent.getIntExtra("Num1", 0)
        var num2 = inIntent.getIntExtra("Num2", 0)
        var calType = inIntent.getStringExtra("CalType")

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            var outIntent = Intent(this, MainActivity::class.java)

            if (calType == "Sum")
                outIntent.putExtra("Result", num1+num2)
            if (calType == "Sub")
                outIntent.putExtra("Result", num1-num2)
            if (calType == "Mul")
                outIntent.putExtra("Result", num1*num2)
            if (calType == "Div")
                outIntent.putExtra("Result", num1/num2)

            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }
    }
}