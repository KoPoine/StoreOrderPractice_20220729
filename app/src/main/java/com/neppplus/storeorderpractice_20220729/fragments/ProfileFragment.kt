package com.neppplus.storeorderpractice_20220729.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.storeorderpractice_20220729.ProfileActivity
import com.neppplus.storeorderpractice_20220729.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    val REQ_FOR_NICK = 1000

//    layout(xml)과 class(kt) 엮어주는 함수
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

//    Fragment class의 동작 코드
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        changeNickBtn.setOnClickListener {
            val myIntent = Intent(requireContext(), ProfileActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_NICK)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQ_FOR_NICK) {
                val changedNick = data?.getStringExtra("changedNick")
                nickTxt.text = changedNick
            }
        }
    }

}