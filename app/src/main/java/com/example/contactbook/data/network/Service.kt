package com.example.contactbook.data.network

import android.util.Log
import com.example.contactbook.core.RetrofitHelper
import com.example.contactbook.data.model.UserModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Service @Inject constructor(private val api: ApiService) {
    private val TAG: String = Service::class.java.simpleName
    suspend fun getUser(): NetworkState<List<UserModelItem>> {
        val response = api.getAllUsers(15, true)
        return if (response.isSuccessful) {
            Log.i(TAG, "${response.isSuccessful}")
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkState.Success(responseBody)
            } else {
                Log.i(TAG, "$response")
                NetworkState.Error(response)
            }
        } else {
            Log.i(TAG, "$response")
            NetworkState.Error(response)
        }

        /*return withContext(Dispatchers.IO){
            val response = retrofit.create(ApiService::class.java).getAllUsers(2,true)
            response.body() ?: emptyList()
        }*/
    }
}