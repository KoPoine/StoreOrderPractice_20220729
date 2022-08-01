package com.neppplus.storeorderpractice_20220729

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_profile_image.*

class DetailProfileImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_profile_image)

        val logoUrl = intent.getStringExtra("logoUrl")

        Glide.with(this).load(logoUrl).into(photoView)
    }
}