package com.example.contactbook.data.network

import com.example.contactbook.data.model.UserModelItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("user")
    suspend fun getAllUsers(@Query("size")size:Int,@Query("is_json")is_json:Boolean): Response<List<UserModelItem>>
}