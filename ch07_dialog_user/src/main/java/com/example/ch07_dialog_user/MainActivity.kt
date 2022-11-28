package com.example.ch07_dialog_user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var tvName : TextView
    lateinit var tvEmail : TextView
    lateinit var btn1 : Button

    lateinit var edtName : TextView
    lateinit var edtEmail : TextView
    lateinit var toastTxt : TextView

    lateinit var dialogView : View
    lateinit var toastView : View

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "사용자 정보 입력"

        tvName = findViewById<TextView>(R.id.tvName)
        tvEmail = findViewById<TextView>(R.id.tvEmail)
        btn1 = findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener {
            dialogView = View.inflate(this, R.layout.dialog1, null)
            var dlg = AlertDialog.Builder(this)
            dlg.setTitle("사용자 정보 입력")
            dlg.setIcon(R.drawable.ic_menu_allfriends)
            dlg.setView(dialogView)

            dlg.setPositiveButton("확인") { dialog, which ->
                edtName = dialogView.findViewById<EditText>(R.id.edtName)
                edtEmail = dialogView.findViewById<EditText>(R.id.edtEmail)

                tvName.text = edtName.text.toString()
                tvEmail.text = edtEmail.text.toString()
            }

            dlg.setNegativeButton("취소") { dialog, which ->
                var toast = Toast(this)
                toastView = View.inflate(this, R.layout.toast1, null)
                toastTxt = toastView.findViewById<TextView>(R.id.toastTxt)
                toastTxt.text = "취소했습니다."
                toast.view = toastView
                toast.show()
            }
            dlg.show()
        }

    }
}