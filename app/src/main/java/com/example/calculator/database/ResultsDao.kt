package com.example.calculator.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ResultsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertResult(results: Results)
    @Update
    fun updateResult(results: Results)
    @Delete
    fun deleteResult(results: Results)
    @Query("SELECT * FROM results_table ORDER BY resultId ASC")
    fun getAllResults(): LiveData<List<Results>>
}