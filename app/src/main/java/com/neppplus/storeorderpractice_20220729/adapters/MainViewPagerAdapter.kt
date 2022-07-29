package com.neppplus.storeorderpractice_20220729.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.neppplus.storeorderpractice_20220729.fragments.PizzaFragment
import com.neppplus.storeorderpractice_20220729.fragments.ProfileFragment

class MainViewPagerAdapter(
    fm : FragmentManager
) : FragmentPagerAdapter(fm) {

//    몇장짜리인가
    override fun getCount() = 2 // 함수의 결과가 한줄로 도출된다면, 함수의 축약도 가능하다.

//    position 값에 따라 어떤 걸 return 해줄건지?
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PizzaFragment()
            else -> ProfileFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "피자 주문"
            else -> "내 정보 설정"
        }
    }

}