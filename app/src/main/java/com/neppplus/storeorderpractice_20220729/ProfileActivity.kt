package com.neppplus.storeorderpractice_20220729

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        saveBtn.setOnClickListener {
            val inputNick = changeNickEdt.text.toString()

            if (inputNick.isBlank()) {
//                입력한 닉네임(EditText)의 값이 빈칸(null)이거나 공백("  ")일 때 실행하는 분기처리
                Toast.makeText(this, "닉네임은 공백이거나 빈 칸일 수 없습니다", Toast.LENGTH_SHORT).show()
//                setOnClickListener 한정 > 이 코드 아래의 나머지 코드가 작성되지 않고 로직 종료
                return@setOnClickListener
            }

            val resultIntent = Intent()
            resultIntent.putExtra("changedNick", inputNick)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}