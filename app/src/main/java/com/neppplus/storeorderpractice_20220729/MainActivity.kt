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

    }
}