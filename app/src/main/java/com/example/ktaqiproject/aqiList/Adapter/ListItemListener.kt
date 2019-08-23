package com.example.ktaqiproject.aqiList.Adapter;


import com.example.ktaqiproject.database.Entities.AqiEntity;

/**
 *  清單項目數值接口
 * */
interface ListItemListener {
    //刪除資料用
    fun removeItemFromDatabase(item: AqiEntity)
}
