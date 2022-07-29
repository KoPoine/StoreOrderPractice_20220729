package com.neppplus.storeorderpractice_20220729

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.neppplus.storeorderpractice_20220729.datas.StoreData
import kotlinx.android.synthetic.main.activity_store_detail.*

class StoreDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)

//        intent로 보내준 StoreData 받기
        val storeData = intent.getSerializableExtra("storeData") as StoreData

//        받아온 StoreData 기반으로 UI 반영하기
        Glide.with(this)
            .load(storeData.imgUrl)
            .into(logoImg)

        titleTxt.text = storeData.title

        scoreRatingBar.rating = storeData.score.toFloat()

        scoreTxt.text = "(${ storeData.score })"  // 소수점 단위가 0이면 어떻게 표현을 해줄까?

        phoneNumTxt.text = storeData.phoneNum

//        별도의 클릭 이벤트 처리 (전화번호 버튼 클릭 이벤트 처리)
        callBtn.setOnClickListener {
            val myUri = Uri.parse("tel:${storeData.phoneNum}")
            val myIntent = Intent( Intent.ACTION_CALL, myUri )
            startActivity(myIntent)
        }
    }
}