package com.example.calculator.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Results::class], version = 1, exportSchema = false)
abstract class ResultsDatabase : RoomDatabase() {

    abstract fun resultsDao(): ResultsDao

    companion object {
        @Volatile
        private var INSTANCE: ResultsDatabase? = null
        fun getDatabase(context: Context): ResultsDatabase {
            synchronized(this) {
                val instance = INSTANCE
                if (instance != null) {
                    return instance
                }
                synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ResultsDatabase::class.java,
                        "results_database"
                    ).build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
}
