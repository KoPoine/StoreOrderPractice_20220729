package com.neppplus.storeorderpractice_20220729

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
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

//            권한이 허가 되었는지 / 아닌지에 "상황"에 따라 별도로 실행될 코드 작성
            val pl = object : PermissionListener{
                override fun onPermissionGranted() {
//                    실제로 권한이 Ok 되었을때 실행할 코드
                    val myUri = Uri.parse("tel:${storeData.phoneNum}")
                    val myIntent = Intent( Intent.ACTION_CALL, myUri )
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//                    최종 권한이 거절된 경우 (보통 toast로 안내 처리)
                    Toast.makeText(this@StoreDetailActivity, "권한이 거절되었습니다.", Toast.LENGTH_SHORT).show()
                }
            }

//            실제 권한 확인 요청
            TedPermission.create()
                .setPermissionListener(pl)  // 만들어둔 PermissionListener 변수
                .setPermissions(Manifest.permission.CALL_PHONE)  // 우리가 획득하고 싶은 권한
                .check()
        }

        goHomePageBtn.setOnClickListener {
            // 각 상점별 홈페이지 방문 Event > StoreData에 Url이라는 새로운 String 생성자 추가
            val myUri = Uri.parse("https://www.pizzahut.co.kr/")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

        logoImg.setOnClickListener {
            val myIntent = Intent(this, DetailProfileImageActivity::class.java)
            myIntent.putExtra("logoUrl", storeData.imgUrl)
            startActivity(myIntent)
        }
    }
}