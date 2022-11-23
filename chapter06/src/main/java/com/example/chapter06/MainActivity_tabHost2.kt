package com.example.chapter06

import android.app.TabActivity
import android.os.Bundle

@Suppress("deprecation")
class MainActivity_tabHost2 : TabActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tabhost2)

        var tapHost = this.tabHost

        var tabSpecDog = tabHost.newTabSpec("DOG").setIndicator("강아지")
        tabSpecDog.setContent(R.id.tabDog)
        tabHost.addTab(tabSpecDog)

        var tabSpecCat = tabHost.newTabSpec("CAT").setIndicator("고양이")
        tabSpecCat.setContent(R.id.tabCat)
        tabHost.addTab(tabSpecCat)

        var tabSpecRabbit = tabHost.newTabSpec("RABBIT").setIndicator("토끼")
        tabSpecRabbit.setContent(R.id.tabRabbit)
        tabHost.addTab(tabSpecRabbit)

        var tabSpecHorse = tabHost.newTabSpec("HORSE").setIndicator("말")
        tabSpecHorse.setContent(R.id.tabHorse)
        tabHost.addTab(tabSpecHorse)

        tabHost.currentTab = 0  // 처음 화면 : 강아지
    }
}