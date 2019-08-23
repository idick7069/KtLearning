package com.example.ktaqiproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ktaqiproject.database.DAO.AqiDao
import com.example.ktaqiproject.database.Entities.AqiEntity

@Database(entities = [AqiEntity::class], version = 1)
abstract class MyRoomDatabase : RoomDatabase() {

    abstract fun aqiDao(): AqiDao

    companion object {
        const val DATABASE_NAME = "aqi.db"
        var myInstance: MyRoomDatabase? = null

        /*
    * 單例取資料庫
    * */
        fun getDatabase(context: Context): MyRoomDatabase? {
            if (myInstance == null) {
                synchronized(MyRoomDatabase::class) {
                    myInstance = Room.databaseBuilder(
                        context.applicationContext,
                        MyRoomDatabase::class.java,
                        DATABASE_NAME
                    ).allowMainThreadQueries()
                        .build()
                }
            }
            return myInstance
        }

        fun destroyDataBase() {
            myInstance = null
        }
    }


}