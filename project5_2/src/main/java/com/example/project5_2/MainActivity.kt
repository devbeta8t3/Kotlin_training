package com.example.project5_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 바인딩
        var edit1 = findViewById<EditText>(R.id.Edit1)
        var edit2 = findViewById<EditText>(R.id.Edit2)

        var btnAdd = findViewById<Button>(R.id.BtnAdd)
        var btnSub = findViewById<Button>(R.id.BtnSub)
        var btnMul = findViewById<Button>(R.id.BtnMul)
        var btnDiv = findViewById<Button>(R.id.BtnDiv)

        var btnResult = findViewById<TextView>(R.id.Result)

        // 숫자버튼
        var numButtons = ArrayList<Button>(10)
        var numBtnIds = arrayOf(R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4,
                                R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9)
        println(numBtnIds[0])
        for (i in 0..9){
            numButtons.add(findViewById<Button>(R.id.numBtnIds[i]))
        }

        for (i in 0..9){

        }

    }
}