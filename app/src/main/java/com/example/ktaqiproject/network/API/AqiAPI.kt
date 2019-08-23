package com.example.ktaqiproject.network.API

import com.example.ktaqiproject.database.Entities.AqiEntity
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AqiAPI {

    //https://opendata.epa.gov.tw/api/v1/AQI?format=json
    @GET("api/v1/AQI")
    fun search(@Query("format") format: String): Call<List<AqiEntity>>
}