package com.example.project5_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
//import kotlinx.android.synthetic.main.activity_main.*

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

        var textResult = findViewById<TextView>(R.id.Result)

        // 액션 리스너 (덧셈)
        btnAdd.setOnTouchListener { view, motionEvent ->
            var num1 = edit1.text.toString()
            var num2 = edit2.text.toString()
            var result = num1.toInt() + num2.toInt()
            textResult.text = "계산 결과 >> " +result.toString()
            false
        }
        // 액션 리스너 (뺄셈)
        btnAdd.setOnTouchListener { view, motionEvent ->
            var num1 = edit1.text.toString()
            var num2 = edit2.text.toString()
            var result = num1.toInt() - num2.toInt()
            textResult.text = "계산 결과 >> " +result.toString()
            false
        }
        // 액션 리스너 (곱셈)
        btnAdd.setOnTouchListener { view, motionEvent ->
            var num1 = edit1.text.toString()
            var num2 = edit2.text.toString()
            var result = num1.toInt() * num2.toInt()
            textResult.text = "계산 결과 >> " +result.toString()
            false
        }
        // 액션 리스너 (나눗셈)
        btnAdd.setOnTouchListener { view, motionEvent ->
            var num1 = edit1.text.toString()
            var num2 = edit2.text.toString()
            var result = num1.toInt() / num2.toInt()
            textResult.text = "계산 결과 >> " +result.toString()
            false
        }

        // 숫자버튼
        var numButtons = ArrayList<Button>(10)
        var numBtnIds = arrayOf(R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4,
                                R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9)

        for (i in 0..9 step 1){
            numButtons.add(findViewById<Button>(numBtnIds[i]))
        }

        for (i in 0..9){

        }

    }
}