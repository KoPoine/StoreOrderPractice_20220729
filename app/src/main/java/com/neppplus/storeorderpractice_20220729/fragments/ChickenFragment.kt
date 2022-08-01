package com.neppplus.storeorderpractice_20220729.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.storeorderpractice_20220729.R
import com.neppplus.storeorderpractice_20220729.StoreDetailActivity
import com.neppplus.storeorderpractice_20220729.adapters.StoreListViewAdapter
import com.neppplus.storeorderpractice_20220729.datas.StoreData
import kotlinx.android.synthetic.main.fragment_pizza.*

class ChickenFragment : Fragment() {

//    StoreClass 더미데이터를 담아줄 ArrayList를 작성
    val mChickenList = ArrayList<StoreData>()

//    ListView사용될 어댑터 클래스 lateinit var 로 생성
    lateinit var mChickenAdapter : StoreListViewAdapter

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
        mChickenList.add(StoreData("교촌치킨", 4.3,"1577-8080",
            "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg"))
        mChickenList.add(StoreData("BBQ", 3.8, "1577-8080",
            "http://mblogthumb-phinf.pstatic.net/20160530_116/ppanppane_14646177654870uGy9_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%281%29.png?type=w800"))
        mChickenList.add(StoreData("땅땅치킨", 4.5, "1577-3082",
            "https://www.pngplay.com/wp-content/uploads/6/Dominos-Pizza-Logo-Background-PNG-Image.png"))
        mChickenList.add(StoreData("굽네치킨", 3.2, "1577-0077",
            "https://mblogthumb-phinf.pstatic.net/20160530_62/ppanppane_14646177047843NP3E_PNG/%B9%CC%BD%BA%C5%CD%C7%C7%C0%DA_%B7%CE%B0%ED_%283%29.png?type=w800"))

//        어댑터 객체화 및 ListView 변수와 연결
        mChickenAdapter = StoreListViewAdapter(requireContext(), R.layout.store_list_item, mChickenList)
        pizzaListView.adapter = mChickenAdapter

        pizzaListView.setOnItemClickListener { adapterView, view, i, l ->
            val myIntent = Intent(requireContext(), StoreDetailActivity::class.java)
            myIntent.putExtra("storeData", mChickenList[i])
            startActivity(myIntent)
        }

    }

}