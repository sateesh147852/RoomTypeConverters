package com.roomtypeconverters.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.roomtypeconverters.model.Person

@Database(entities = [Person::class], version = 1)
@TypeConverters(TypeConverter::class)
abstract class PersonDataBase : RoomDatabase() {

    abstract fun personDao(): PersonDao

    companion object {

        private var personDataBase: PersonDataBase? = null

        fun getRoomInstance(context: Context): PersonDataBase {
            if (personDataBase == null) {
                synchronized(this) {
                    personDataBase =
                        Room.databaseBuilder(context, PersonDataBase::class.java, "PERSON_DATABASE")
                            .build()
                }
            }
            return personDataBase!!
        }
    }

}