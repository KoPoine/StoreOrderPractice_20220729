package com.neppplus.storeorderpractice_20220729

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        자동로그인 확인 로직 작성


        val myHandler = Handler(Looper.getMainLooper())

        myHandler.postDelayed(
            {
                val myIntent = Intent(this, MainActivity::class.java)
                startActivity(myIntent)
                finish()
            }, 2500
        )
    }
}