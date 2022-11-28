package com.example.ch07_dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.Objects

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button

    var checkArray = booleanArrayOf(false, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById<Button>(R.id.btn1)
        btn2 = findViewById<Button>(R.id.btn2)
        btn3 = findViewById<Button>(R.id.btn3)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
    }

    // OnClickListener 상속받아 오버라이딩
    override fun onClick(v: View?) {
        var versionArray = arrayOf("오레오", "파이", "큐(10)")
        //var checkArray = booleanArrayOf(false, false, false)  // 상태 저장 위해 밖으로 뺀다.
        var dialog = AlertDialog.Builder(this@MainActivity)

        dialog.setTitle("좋아하는 버전은?")
        dialog.setIcon(R.mipmap.ic_launcher)
        dialog.setMultiChoiceItems(versionArray, checkArray) { dialog, which, isChecked ->
            if (which === 0 && isChecked) {
                btn1.text = versionArray[which]
                btn1.visibility = View.VISIBLE
                checkArray[0] = true
            }
            if (which === 0 && !isChecked) {
                btn1.text = versionArray[which]
                btn1.visibility = View.GONE
                checkArray[0] = false
            }
            if (which === 1 && isChecked) {
                btn2.text = versionArray[which]
                btn2.visibility = View.VISIBLE
                checkArray[1] = true
            }
            if (which === 1 && !isChecked) {
                btn2.text = versionArray[which]
                btn2.visibility = View.GONE
                checkArray[1] = false
            }
            if (which === 2 && isChecked) {
                btn3.text = versionArray[which]
                btn3.visibility = View.VISIBLE
                checkArray[2] = true
            }
            if (which === 2 && !isChecked) {
                btn3.text = versionArray[which]
                btn3.visibility = View.GONE
                checkArray[2] = false
            }
        }
        // 모두 체크 해제된 상태에서 닫기 누르면 '대화상자' 버튼 표시하기.
        dialog.setPositiveButton("닫기") { dialog, which ->
            if (checkArray[0] === false && checkArray[1] === false && checkArray[2] === false) {   // 이건 닫기 리스너에 넣자. checkArray = false,false,false 일때...
                btn1.text = "대화상자"
                btn1.visibility = View.VISIBLE
            }
        }
        dialog.show()
    }
}