package com.example.ch07_dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.Objects

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var btnLayout = findViewById<LinearLayout>(R.id.btnLayout)
        var btn1 = findViewById<Button>(R.id.btn1)
        var btn2 = findViewById<Button>(R.id.btn2)
        var btn3 = findViewById<Button>(R.id.btn3)

//        var btnArr = arrayListOf<Button>(btn1, btn2, btn3)
        // 레이아웃 클릭 리스너 test - done
//        btnLayout.setOnClickListener {
//            Toast.makeText(this, "테스트", Toast.LENGTH_SHORT).show()
//        }


        btn1.setOnClickListener {
            var versionArray = arrayOf("오레오", "파이", "큐(10)")
            var checkArray = booleanArrayOf(false, false, false)
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
                if (!isChecked) {   // 이건 닫기 리스너에 넣자. checkArray = false,false,false 일때...
                    btn1.text = "대화상자"
                    btn1.visibility = View.VISIBLE
                }

            }
            dialog.setPositiveButton("닫기", null)
            dialog.show()

        }

    }
}