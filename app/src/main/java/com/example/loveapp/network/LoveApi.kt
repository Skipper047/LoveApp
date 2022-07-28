package com.example.loveapp.network

import com.example.loveapp.model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun calculate(@Query("fname")firstName:String, @Query("sname")secondName:String,
                  @Header("X-RapidAPI-Key")key:String = "7509528a8amsh9d500e1b7f0e717p132b0ajsn129975cdd2ce",
                  @Header("X-RapidAPI-Host")host: String= "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}