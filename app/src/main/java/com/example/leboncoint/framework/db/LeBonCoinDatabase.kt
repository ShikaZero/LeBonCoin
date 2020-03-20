package com.example.leboncoint.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


const val DATABASE_NAME = "leboncoin.db"
const val DATABASE_VERSION = 1

@Database(
    entities = [AlbumEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class LeBonCoinDatabase : RoomDatabase() {

    // Design pattern Singleton
    companion object {
        private var INSTANCE: LeBonCoinDatabase? = null
        fun getDatabase(context: Context): LeBonCoinDatabase {
            if (INSTANCE == null) {
                val instance = Room.databaseBuilder(context.applicationContext, LeBonCoinDatabase::class.java, DATABASE_NAME).allowMainThreadQueries().build()
                INSTANCE = instance
            }
            return INSTANCE!!
        }
    }

    abstract fun albumDao() : AlbumsDao

}