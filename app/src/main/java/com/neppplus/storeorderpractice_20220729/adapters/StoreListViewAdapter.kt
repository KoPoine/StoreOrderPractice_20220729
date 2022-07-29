package com.neppplus.storeorderpractice_20220729.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.neppplus.storeorderpractice_20220729.datas.StoreData
import kotlinx.android.synthetic.main.store_list_item.view.*

class StoreListViewAdapter (
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<StoreData>
        ): ArrayAdapter<StoreData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(resId, null)
        }

        val row = tempRow!!

        val data = mList[position]

        row.titleTxt.text = data.title
        row.scoreRatingBar.rating = data.score.toFloat()
        Glide.with(mContext)           // with(context 자료형) => 어느 화면에서 사용할건지
            .load(data.imgUrl)         // load(string으로 구성된 url주소) => 어떤 이미지 사용할건지
            .into(row.storeImageView)  // into(target => 사용할 이미지뷰) => 어느 View에 넣을 건지

        return row
    }

}