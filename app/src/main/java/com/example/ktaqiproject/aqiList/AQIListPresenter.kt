package com.example.ktaqiproject.aqiList;

import com.example.ktaqiproject.database.DatabaseManager
import com.example.ktaqiproject.network.INetworkController

class AQIListPresenter(private val view: AQIListContract.View, private val databaseManager: DatabaseManager,
                       private val networkController: INetworkController ) : AQIListContract.Presenter {
    override fun successLoad() {

    }

    override fun loadDataFromApi() {
       networkController.loadAqiData()
    }

}
