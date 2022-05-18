package com.example.iphone11promax

data class Login(val token:Int)
{
    companion object login{
        var userToken:Int?=null
    }
}
