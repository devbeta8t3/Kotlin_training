package com.example.kotlin_network_retrofit2

import retrofit2.Call
import retrofit2.http.GET

interface UserInfoService {
    @GET("KotlinTest/kotlinNetTestFile.jsp")
    fun getPeople(): Call<UserInfoList<Any?>>
}