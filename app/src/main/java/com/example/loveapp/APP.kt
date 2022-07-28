package com.example.loveapp

import android.app.Application
import androidx.room.Room
import com.example.loveapp.network.LoveApi
import com.example.loveapp.network.RetrofitService
import com.example.loveapp.room.AppDatabase

class APP : Application() {

    companion object{
        lateinit var api: LoveApi
        lateinit var database: AppDatabase
    }



    override fun onCreate() {
        super.onCreate()
        val retrofit= RetrofitService()
        api = retrofit.api

        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }
}