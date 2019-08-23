package com.example.ktaqiproject.database.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ktaqiproject.database.Entities.AqiEntity

@Dao
interface AqiDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAqi(aqiEntity: AqiEntity)

    @Query("SELECT * FROM Aqi")
    fun getAqiAll():List<AqiEntity>?

    @Query("SELECT * FROM Aqi WHERE SiteId = :siteId")
    fun getAqiBySiteId(siteId: String):AqiEntity?
}