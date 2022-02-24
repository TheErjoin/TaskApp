package com.example.taskappkotlin

import android.app.Application
import androidx.room.Room
import com.example.taskappkotlin.data.room.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    companion object {
        lateinit var appDatabase: AppDatabase
    }
}