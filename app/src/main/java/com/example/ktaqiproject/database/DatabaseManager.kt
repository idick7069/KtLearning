package com.example.ktaqiproject.database

import android.content.Context
import com.example.ktaqiproject.database.DAO.AqiDao

class DatabaseManager(context: Context) {
    var db: MyRoomDatabase
    var aqiDao: AqiDao

    init {
        db = MyRoomDatabase.getDatabase(context)!!
        aqiDao = db.aqiDao()
    }

    companion object {

        var mInstance: DatabaseManager? = null

        fun getInstance(context: Context): DatabaseManager? {
            if (mInstance == null) {
                synchronized(DatabaseManager::class) {
                    if (mInstance == null) {
                        mInstance = DatabaseManager(context)
                    }
                }
            }
            return mInstance
        }
    }

}