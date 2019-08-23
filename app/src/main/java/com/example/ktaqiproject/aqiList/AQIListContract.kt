package com.example.ktaqiproject.aqiList;

import com.example.ktaqiproject.database.Entities.AqiEntity
import java.util.ArrayList

interface AQIListContract {
    interface Presenter {
        fun loadDataFromApi()
        fun successLoad()
    }

    interface View {
        fun setDataToListview(categoriesToList: ArrayList<AqiEntity>)
        fun setDairyToHeader(list: List<String>)
        fun showMessage(msg: String)
    }
}
