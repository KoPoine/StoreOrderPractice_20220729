package com.neppplus.storeorderpractice_20220729

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.storeorderpractice_20220729.adapters.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mPagerAdapter : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPagerAdapter = MainViewPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mPagerAdapter
        mainTabLayout.setupWithViewPager(mainViewPager)

//        피자 리스트 중복 생성 막기 2
        mainViewPager.offscreenPageLimit = 3 // 프래그먼트 3개는 반드시 생성을 시켜놓아라.

    }
}