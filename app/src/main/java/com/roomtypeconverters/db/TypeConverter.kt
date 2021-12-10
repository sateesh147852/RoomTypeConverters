package com.roomtypeconverters.db

import androidx.room.TypeConverter
import java.util.*


class TypeConverter {

    @TypeConverter
    fun dateToTimeStamp(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun timeStampToDate(long: Long): Date {
        return Date(long)
    }

}