package com.example.ktaqiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ktaqiproject.aqiList.AQIListContract
import com.example.ktaqiproject.aqiList.AQIListPresenter
import com.example.ktaqiproject.database.DAO.AqiDao
import com.example.ktaqiproject.database.DatabaseManager
import com.example.ktaqiproject.database.Entities.AqiEntity
import com.example.ktaqiproject.network.NetworkController
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList


class MainActivity : AppCompatActivity(), AQIListContract.View {


    val TAG = "MainActivity"
    lateinit var databaseManager: DatabaseManager
    lateinit var aqiDao: AqiDao
    lateinit var aqiListPresenter: AQIListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        app_toolbar2.setTitle(R.string.toolbar_title)

        initParam()
//        databaseManager = DatabaseManager.getInstance(context = this)!!
//
//
//        var aqiEntity = AqiEntity(0, "taichung", "2")
//
//        aqiDao = databaseManager.aqiDao
//
//        aqiDao.insertAqi(aqiEntity)
//
//        Log.d(TAG, aqiDao.getAqiAll().toString())


    }

    fun initParam() {
        aqiListPresenter =
            AQIListPresenter(
                this,
                DatabaseManager.getInstance(this)!!,
                NetworkController.getInstance(this)!!
            )
        NetworkController.getInstance(this)

        aqiListPresenter.loadDataFromApi()
    }

    override fun setDataToListview(categoriesToList: ArrayList<AqiEntity>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setDairyToHeader(list: List<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
