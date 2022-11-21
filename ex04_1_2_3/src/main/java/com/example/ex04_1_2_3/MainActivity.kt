package com.example.ex04_1_2_3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main) // xml 안쓴다

        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, // width
                                               LinearLayout.LayoutParams.MATCH_PARENT) // height

        val btn = Button(this) // new 생략
        btn.text = "버튼입니다."
        btn.setBackgroundColor(Color.MAGENTA)
    }
}