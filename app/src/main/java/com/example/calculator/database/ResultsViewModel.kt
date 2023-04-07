package com.example.calculator.database

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultsViewModel(val database: ResultsDao,
                       application: Application) : AndroidViewModel(application) {

    val getAllResults: LiveData<List<Results>>
    private val repository: ResultsRepository

    init {
        val resultsDao = ResultsDatabase.getDatabase(application).resultsDao()
        repository = ResultsRepository(resultsDao)
        getAllResults = repository.getAllResults
    }
//
    fun addResult(results: Results){
        viewModelScope.launch(Dispatchers.IO){
            repository.addResults(results)
        }
    }

}

class ResultsViewModelFactory(
    private val dataSource: ResultsDao,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultsViewModel::class.java)) {
            return ResultsViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
