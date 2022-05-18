package com.example.iphone11promax.Retrofit


import com.example.iphone11promax.Login
import com.example.iphone11promax.foodClass
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST



interface RetApi {
    @POST("/auth/login")
    fun login (@Body hashMap: HashMap<String,String>): Call<Login>

    @GET("/dishes?version=1.2")
    fun getDishes():Call<ArrayList<foodClass>>
}