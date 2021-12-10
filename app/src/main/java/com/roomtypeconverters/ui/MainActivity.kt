package com.roomtypeconverters.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.roomtypeconverters.databinding.ActivityMainBinding
import com.roomtypeconverters.db.PersonDao
import com.roomtypeconverters.db.PersonDataBase
import com.roomtypeconverters.model.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var personDao: PersonDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        personDao = PersonDataBase.getRoomInstance(this).personDao()

        lifecycleScope.launch {
            personDao.addPerson(Person(2, "Ramesh", 30, Date()))
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    personDao.getPersons()[1].toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}