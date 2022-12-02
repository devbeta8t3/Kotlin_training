package com.example.ch10_activity_dualactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "메인 액티비티"

        var btnCal = findViewById<Button>(R.id.btnCal)
        btnCal.setOnClickListener {
            var edt1 = findViewById<EditText>(R.id.edt1)
            var edt2 = findViewById<EditText>(R.id.edt2)
            var radioSum = findViewById<RadioButton>(R.id.radioSum)
            var radioSub = findViewById<RadioButton>(R.id.radioSub)
            var radioMul = findViewById<RadioButton>(R.id.radioMul)
            var radioDiv = findViewById<RadioButton>(R.id.radioDiv)
            var intent = Intent(this, SecondActivity::class.java)

            if (radioSum.isChecked) // review: when (item.itemId) 구문이 더 깰끔하다.
                intent.putExtra("CalType", "Sum")
            else if (radioSub.isChecked)
                intent.putExtra("CalType", "Sub")
            else if (radioMul.isChecked)
                intent.putExtra("CalType", "Mul")
            else if (radioDiv.isChecked)
                intent.putExtra("CalType", "Div")
            else {
                Toast.makeText(this, "계산 종류를 선택해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            intent.putExtra("Num1", edt1.text.toString().toInt())
            intent.putExtra("Num2", edt2.text.toString().toInt())
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            var result = data!!.getIntExtra("Result", 0)
            Toast.makeText(this, "계산결과 : $result", Toast.LENGTH_SHORT).show()
        }
    }
}