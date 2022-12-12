package com.example.kotlin_network_retrofit2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

//    lateinit var tv1 : TextView
    lateinit var btn1 : Button
//    lateinit var listID : TextView
//    lateinit var listName : TextView
//    lateinit var listPhone : TextView
//    lateinit var listGrade : TextView
//    lateinit var listTime : TextView
//    lateinit var userList : UserInfoList<UserInfo>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        tv1 = findViewById<TextView>(R.id.tv1)
        btn1 = findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener {
            requestList()
        }
    }

    private fun requestList() {
        val baseURL = "http://10.100.204.22:8080"
        var gson1 : Gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
                               .baseUrl(baseURL)
                               .addConverterFactory(GsonConverterFactory.create())
                               .build()
        val service = retrofit.create(UserInfoService::class.java)

        service.getPeople().enqueue(object : Callback<UserInfoList<Any?>> {

            override fun onResponse(call: Call<UserInfoList<Any?>>, response: Response<UserInfoList<Any?>>) {
                var userList1 = response.body() // 응답된 json을 userList1에 담는다.
//                for (i in 0..userList1!!.datas.size-1) {
//                  //userList1 반복작업용
//                }

                var listView = findViewById<View>(R.id.listView) as ListView
                var listAdapter = ListViewAdapter(this@MainActivity, userList1!!)
                listView.adapter = listAdapter

            }

            override fun onFailure(call: Call<UserInfoList<Any?>>, t: Throwable) {

                // 에러메시지를 Toast로 출력하는 것도 가능!
            }
        })//서비스.ENQUEUE END
    }


}

//리스트뷰 어댑터
class ListViewAdapter(var context: Context, var items: UserInfoList<Any?>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.datas.size
    }

    override fun getItem(p0: Int): Any {
        return items.datas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view : View = LayoutInflater.from(context).inflate(R.layout.list, null)
        var listID = view.findViewById<TextView>(R.id.listID)
        var listName = view.findViewById<TextView>(R.id.listName)
        var listPhone = view.findViewById<TextView>(R.id.listPhone)
        var listGrade = view.findViewById<TextView>(R.id.listGrade)
        var listTime = view.findViewById<TextView>(R.id.listTime)

        listID.text = items.datas[p0].ID
        listName.text = items.datas[p0].NAME
        listPhone.text = items.datas[p0].PHONE
        listGrade.text = items.datas[p0].GRADE.toString()
        listTime.text = items.datas[p0].WRITE_TIME

        return view
    }
}//리스트뷰 어댑터 END