package com.example.loveapp

import android.app.Application
import com.example.loveapp.network.LoveApi
import com.example.loveapp.network.RetrofitService

class APP : Application() {

    companion object{
        lateinit var api: LoveApi
    }

    override fun onCreate() {
        super.onCreate()
        val retrofit= RetrofitService()
        api = retrofit.api
    }
}