package com.example.ch06_actionbar_fragment

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBar.Tab
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

@Suppress("deprecation")
class MainActivity : AppCompatActivity(), ActionBar.TabListener {

    lateinit var tab1 : Tab
    lateinit var tab2 : Tab
    lateinit var tab3 : Tab

    var myFrags = arrayOfNulls<MyTabFragment>(3)    // null 배열 생성(fragment 저장용)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        title = "액션바 & 프레그먼트"

        //bar 만들기
        var bar = this.supportActionBar // androidx 버전으로 맞춰주자. (with Tab)
        bar!!.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        //tab 만들고 bar에 꽂아주기
        tab1 = bar.newTab()
        tab1.text = "음악별"
        tab1.setTabListener(this)
        bar.addTab(tab1)

        tab2 = bar.newTab()
        tab2.text = "가수별"
        tab2.setTabListener(this)
        bar.addTab(tab2)

        tab3 = bar.newTab()
        tab3.text = "앨범별"
        tab3.setTabListener(this)
        bar.addTab(tab3)
        //////////////////////////////bar, tab 만들기 끝


    }

    //내부 클래스
    class MyTabFragment : Fragment() {

        var tabName : String? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            //arguments(내장객체)는 Bundle 을 리턴한다.
            var data = arguments
            tabName = data!!.getString("tabName")
        }

        //뷰(View) 만들기 : 리턴값이 view 이어야 한다.
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            var param = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                                  LinearLayout.LayoutParams.MATCH_PARENT)

            var baseLayout = LinearLayout(super.getActivity())
            baseLayout.orientation = LinearLayout.VERTICAL
            baseLayout.layoutParams = param

            if (tabName == "음악별")
                baseLayout.setBackgroundColor(Color.RED)
            if (tabName == "가수별")
                baseLayout.setBackgroundColor(Color.GREEN)
            if (tabName == "앨범별")
                baseLayout.setBackgroundColor(Color.BLUE)

            return baseLayout
        }
    }

    override fun onTabSelected(tab: Tab, ft: FragmentTransaction) {
        var myTabFrag : MyTabFragment? = null

        //첨에 선택하면 배열에서 내용이 있는지(null) 검사하고, 없으면 저장하자.
        if (myFrags[tab.position] == null) {
            // fragment 객체를 새로 만들어서 사용하고, 배열에 보관한다.
            myTabFrag = MyTabFragment() // 만들기. new 생략됨
            var data = Bundle()
            data.putString("tabName", tab.text.toString())
            myTabFrag.arguments = data
            myFrags[tab.position] = myTabFrag   // 배열에 저장
        }
        else {
            myTabFrag = myFrags[tab.position]   // 배열에 있는걸 가져오기
        }

        ft.replace(android.R.id.content, myTabFrag!!)
    }

    override fun onTabUnselected(tab: Tab?, ft: FragmentTransaction?) {
    }

    override fun onTabReselected(tab: Tab?, ft: FragmentTransaction?) {
    }

}