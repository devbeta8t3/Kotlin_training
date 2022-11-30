package com.example.ch10_activity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        title = "투표 결과"

        // 인텐트 데이터 받기
        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
        var imageName = intent.getStringArrayExtra("ImageName")

        // 텍스트뷰, 레이팅바 만들기(Null)
        var tv = arrayOfNulls<TextView>(imageName!!.size)
        var rBar = arrayOfNulls<RatingBar>(imageName.size)

        // 텍스트뷰, 레이팅바 ID 배열
        var tvId = arrayOf(R.id.tv1, R.id.tv2, R.id.tv3,
                           R.id.tv4, R.id.tv5, R.id.tv6,
                           R.id.tv7, R.id.tv8, R.id.tv9)
        var rBarId = arrayOf(R.id.rBar1, R.id.rBar2, R.id.rBar3,
                             R.id.rBar4, R.id.rBar5, R.id.rBar6,
                             R.id.rBar7, R.id.rBar8, R.id.rBar9)

        // 텍스트뷰, 레이팅바 바인딩
        for (i in voteResult!!.indices) {
            tv[i] = findViewById<TextView>(tvId[i])
            rBar[i] = findViewById<RatingBar>(rBarId[i])
        }
        // 텍스트뷰(작품명), 레이팅바(득표수) 입력하기
        for (i in voteResult.indices) {
            tv[i]!!.text = imageName[i]
            rBar[i]!!.rating = voteResult[i].toFloat()
        }

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }

        // Showing Winner
        var tvWin = findViewById<TextView>(R.id.tvWin)
        var imageWin = findViewById<ImageView>(R.id.imageWin)

        var imageField = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                                 R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                                 R.drawable.pic7, R.drawable.pic8, R.drawable.pic9)
        // Max 득표수와 인덱스
        var maxVote = voteResult.maxOrNull()
        var indexOfMax = voteResult.indexOf(maxVote!!)

        tvWin.text = imageName[indexOfMax]
        imageWin.setImageResource(imageField[indexOfMax])
    }
}