package com.roomtypeconverters.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.roomtypeconverters.model.Person

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPerson(person: Person)

    @Query("SELECT * FROM Person")
    suspend fun getPersons(): List<Person>
}