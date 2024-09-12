package com.example.introductiontoroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "person_table")
data class Person(
    @PrimaryKey(autoGenerate = true) val pId:Int,
    @ColumnInfo("person_name")val name: String,
    @ColumnInfo("person_age")val age: Int,
    @ColumnInfo("person_city")val city: String

)
