package com.neppplus.storeorderpractice_20220729.datas

import java.io.Serializable

class StoreData(
    val title : String,
    val score : Double,
    val phoneNum : String,
    val imgUrl : String
) : Serializable{
}