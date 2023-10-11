package com.example.contactbook.domain

import android.util.Log
import com.example.contactbook.data.Repository
import com.example.contactbook.data.database.entities.toDataBase
import com.example.contactbook.data.model.UserModelItem
import com.example.contactbook.data.network.NetworkState
import com.example.contactbook.domain.model.User
import javax.inject.Inject

class GetAllUserUserCase @Inject constructor(private val repository: Repository) {
    private val TAG : String = GetAllUserUserCase::class.java.simpleName

    suspend operator fun invoke(): List<User> {
        val user = repository.getAllUserFromApi()
        return if (user.isNotEmpty()) {
            Log.i(TAG,"FROM API")
            repository.clearUser()
            repository.insertUser(user.map { it.toDataBase() })
            user
        } else {
            Log.i(TAG,"FROM DATA")
            repository.getAllUserFromData()
        }
    }

}