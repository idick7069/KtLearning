package com.example.ktaqiproject.database.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Aqi")
data class AqiEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val SiteName: String? = null,
    var County: String? = null,
    var AQI: String? = null,
    var Pollutant: String? = null,
    var Status: String? = null,
    var SO2: String? = null,
    var CO: String? = null,
    var CO_8hr: String? = null,
    var O3: String? = null,
    var O3_8h: String? = null,
    var PM10: String? = null,

    @SerializedName("PM2.5")
    var PM25: String? = null,
    var NO2: String? = null,
    var NOx: String? = null,
    var NO: String? = null,
    var WindSpeed: String? = null,
    var WindDirec: String? = null,
    var PublishTime: String? = null,

    @SerializedName("PM2.5_AVG")
    var PM25_AVG: String? = null,
    var PM10_AVG: String? = null,
    var SO2_AVG: String? = null,
    var Longitude: String? = null,
    var Latitude: String? = null,
    val SiteId: String? = null
)