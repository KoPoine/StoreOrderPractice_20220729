package com.neppplus.storeorderpractice_20220729.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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


        return row
    }

}