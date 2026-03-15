package com.devforgely.lifeprotocol.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devforgely.lifeprotocol.data.local.dao.QuestionDao
import com.devforgely.lifeprotocol.data.local.entity.QuestionEntity

@Database(entities = [QuestionEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                .createFromAsset("database/app_database.db")
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}