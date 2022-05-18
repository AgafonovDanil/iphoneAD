package com.example.iphone11promax.Retrofit

import com.example.iphone11promax.Retrofit.RetApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object conn {
    fun getRetrofit() : RetApi{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://food.madskill.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val getApi=retrofit.create(RetApi::class.java)
        return getApi
    }

}