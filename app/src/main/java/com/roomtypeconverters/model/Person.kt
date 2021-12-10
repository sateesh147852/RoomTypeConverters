package com.roomtypeconverters.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Person(@PrimaryKey val id: Int,val name: String,val age: Int,val date: Date)
