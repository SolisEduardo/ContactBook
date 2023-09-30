package com.example.contactbook.data

import android.util.Log
import com.example.contactbook.data.model.UserModelItem
import com.example.contactbook.data.network.ApiService
import com.example.contactbook.data.network.NetworkState
import com.example.contactbook.data.network.Service
import javax.inject.Inject

class Repository @Inject constructor(private val api: Service) {
    private val TAG: String = Repository::class.java.simpleName
    suspend fun getAllUser(): NetworkState<List<UserModelItem>> {
        val response: NetworkState<List<UserModelItem>> = api.getUser()
        Log.i(TAG, "")
        return response
    }

}