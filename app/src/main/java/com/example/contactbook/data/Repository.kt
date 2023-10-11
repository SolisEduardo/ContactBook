package com.example.contactbook.data

import android.util.Log
import com.example.contactbook.data.database.dao.UserDao
import com.example.contactbook.data.database.entities.UserEntity
import com.example.contactbook.data.model.UserModelItem
import com.example.contactbook.data.network.ApiService
import com.example.contactbook.data.network.NetworkState
import com.example.contactbook.data.network.Service
import com.example.contactbook.domain.model.User
import com.example.contactbook.domain.model.toDomain
import javax.inject.Inject

class Repository @Inject constructor(private val api: Service, private val userDao: UserDao) {
    private val TAG: String = Repository::class.java.simpleName
    suspend fun getAllUserFromApi(): List<User> {
        val response = api.getUser()
        Log.i(TAG, "Api")
        return response.map {
            it.toDomain()
        }
    }

    suspend fun getAllUserFromData(): List<User> {
        val response = userDao.getAllUser()
        return response.map {
            it.toDomain()
        }
    }
    suspend fun insertUser(user : List<UserEntity>){
        userDao.insertUser(user)
    }

    suspend fun clearUser(){
        userDao.deleteAllUser()
    }

}