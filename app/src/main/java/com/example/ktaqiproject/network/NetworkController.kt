package com.example.ktaqiproject.network

import android.content.Context
import android.util.Log
import com.example.ktaqiproject.database.DatabaseManager
import com.example.ktaqiproject.database.Entities.AqiEntity
import com.example.ktaqiproject.database.MyRoomDatabase
import com.example.ktaqiproject.network.API.AqiAPI
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class NetworkController(context: Context) : INetworkController {


    var db: MyRoomDatabase
    lateinit var retrofit: Retrofit
    lateinit var aqiAPI: AqiAPI
    var baseurl = "https://opendata.epa.gov.tw/"

    init {
        //https://opendata.epa.gov.tw/api/v1/AQI?format=json
        db = MyRoomDatabase.getDatabase(context)!!
        initRetrofit()
    }

    companion object {

        val TAG = "NetworkController"

        var mInstance: NetworkController? = null

        fun getInstance(context: Context): NetworkController? {
            if (mInstance == null) {
                synchronized(NetworkController::class) {
                    if (mInstance == null) {
                        mInstance = NetworkController(context)
                    }
                }
            }
            return mInstance
        }
    }

    override fun initRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
//            .client(getUnsafeOkHttpClient())
            .build()
        aqiAPI = retrofit.create(AqiAPI::class.java)
    }

    override fun loadAqiData() {
        val result = aqiAPI.search("json")
//        Log.d(TAG, result.toString())

        result.enqueue(object :Callback<List<AqiEntity>>{
            override fun onResponse(call: Call<List<AqiEntity>>, response: Response<List<AqiEntity>>) {
                val sb = StringBuffer()
                val list = response.body()
                Log.d(TAG, "${list?.size}個")

                for (p in list!!) {
                    sb.append(p)
                    sb.append("\n")
                    sb.append("---------------------\n")
                }
                Log.d(TAG, sb.toString())
            }

            override fun onFailure(call: Call<List<AqiEntity>>, t: Throwable) {
                Log.d(TAG, "onFailure message => " + t.message)
            }
        })

    }
}