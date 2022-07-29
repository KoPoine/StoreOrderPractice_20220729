package com.neppplus.storeorderpractice_20220729.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.storeorderpractice_20220729.R
import com.neppplus.storeorderpractice_20220729.datas.StoreData

class PizzaFragment : Fragment() {

//    StoreClass 더미데이터를 담아줄 ArrayList를 작성
    val mPizzaList = ArrayList<StoreData>()

//    layout(xml)과 class(kt) 엮어주는 함수
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pizza, container, false)
    }

//    Fragment class의 동작 코드

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        한칸의 리스트뷰에 사용될 더미데이터를 작성
        mPizzaList.add(StoreData("피자헛", 4.3))
        mPizzaList.add(StoreData("파파존스", 3.8))
        mPizzaList.add(StoreData("도미노피자", 4.5))
        mPizzaList.add(StoreData("미스터피자", 3.2))

    }

}