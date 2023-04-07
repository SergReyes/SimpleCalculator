package com.example.calculator.database

import androidx.lifecycle.LiveData

class ResultsRepository(private val resultsDao: ResultsDao) {

    val getAllResults: LiveData<List<Results>> = resultsDao.getAllResults()
    suspend fun addResults(results: Results){
        resultsDao.insertResult(results)
    }
}