package com.example.contactbook.domain

import com.example.contactbook.data.Repository
import com.example.contactbook.data.model.UserModelItem
import com.example.contactbook.data.network.NetworkState

class GetAllUserUserCase {
    private val repository = Repository()

    suspend operator fun invoke() : NetworkState<List<UserModelItem>> = repository.getAllUser()

}