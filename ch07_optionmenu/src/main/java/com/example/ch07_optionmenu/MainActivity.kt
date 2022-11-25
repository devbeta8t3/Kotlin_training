package com.example.ch07_optionmenu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var baseLayout : LinearLayout
    lateinit var editAngle : EditText
    lateinit var img1 : ImageView
    lateinit var img2 : ImageView
    lateinit var img3 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "제주도 사진"
//        title = "배경색 바꾸기"

        baseLayout = findViewById<LinearLayout>(R.id.baseLayout)
        editAngle = findViewById<EditText>(R.id.editAngle)
        img1 = findViewById<ImageView>(R.id.img1)
        img2 = findViewById<ImageView>(R.id.img2)
        img3 = findViewById<ImageView>(R.id.img3)
//        baseLayout = findViewById<LinearLayout>(R.id.baseLayout)
//        btn1 = findViewById<Button>(R.id.btn1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu2, menu)
//        mInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemRotate -> {
//                img1.animate().rotation(45f).start()  // for test - done
                img1.rotation = editAngle.text.toString().toFloat()
                img2.rotation = editAngle.text.toString().toFloat()
                img3.rotation = editAngle.text.toString().toFloat()
                return true
            }
            R.id.item1 -> {
                img1.visibility = View.VISIBLE
                img2.visibility = View.INVISIBLE
                img3.visibility = View.INVISIBLE
                return true
            }
            R.id.item2 -> {
                img1.visibility = View.INVISIBLE
                img2.visibility = View.VISIBLE
                img3.visibility = View.INVISIBLE
                return true
            }
            R.id.item3 -> {
                img1.visibility = View.INVISIBLE
                img2.visibility = View.INVISIBLE
                img3.visibility = View.VISIBLE
                return true
            }
        }
        return false
    }
}