package com.example.contactbook.data.network

import android.util.Log
import com.example.contactbook.core.RetrofitHelper
import com.example.contactbook.data.model.UserModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Service @Inject constructor(private val api: ApiService) {
    private val TAG: String = Service::class.java.simpleName
    suspend fun getUser(): List<UserModelItem> {
        val response = api.getAllUsers(15, true)


       return withContext(Dispatchers.IO){
            response.body() ?: emptyList()
        }
    }
}