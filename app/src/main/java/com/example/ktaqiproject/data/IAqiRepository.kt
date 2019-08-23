package com.example.ktaqiproject.data

import com.example.ktaqiproject.database.Entities.AqiEntity

interface IAqiRepository {
    fun insertAqi(aqiEntity: AqiEntity)

    fun getAqiAll():List<AqiEntity>?

    fun getAqiBySiteId(siteId: String): AqiEntity?
}