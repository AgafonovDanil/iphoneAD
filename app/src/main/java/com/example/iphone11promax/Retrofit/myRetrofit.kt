package com.example.iphone11promax.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class myRetrofit {
    fun getRetrofit() :Retrofit = Retrofit.Builder()
        .baseUrl("https://food.madskill.ru")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}