package com.cookandroid.ch10_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1 = findViewById<Button>(R.id.btn1)
        var radio1 = findViewById<RadioButton>(R.id.radio1)
        var radio2 = findViewById<RadioButton>(R.id.radio2)

        btn1.setOnClickListener {

            if (radio1.isChecked) {
                var intent2 = Intent(this, SecondActivity::class.java)
                startActivity(intent2)
            }
            else if (radio2.isChecked) {
                var intent3 = Intent(this, ThirdActivity::class.java)
                startActivity(intent3)
            }
            else
                Toast.makeText(this, "선택해주세요.", Toast.LENGTH_SHORT).show()
        }
    }
    // todo : 10장은 명화 예제 하나 해보면 실제 써먹을 정도는 됩니다.
}