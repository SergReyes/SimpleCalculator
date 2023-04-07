package com.example.calculator.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "results_table")
data class Results (
    @PrimaryKey(autoGenerate = true)
    var resultId: Int = 0,

    @ColumnInfo(name = "calc")
    var calc: String
    )


