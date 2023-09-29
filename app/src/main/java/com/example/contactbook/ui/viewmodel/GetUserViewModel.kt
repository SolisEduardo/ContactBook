package com.example.contactbook.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactbook.data.model.UserModelItem
import com.example.contactbook.data.network.NetworkState
import com.example.contactbook.domain.GetAllUserUserCase
import kotlinx.coroutines.launch

class GetUserViewModel : ViewModel() {

    private var getAllUserUserCase = GetAllUserUserCase()

    private var _getUser = MutableLiveData<List<UserModelItem>>()
    val getUser: MutableLiveData<List<UserModelItem>>
        get() = _getUser

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getAllUser() {
        viewModelScope.launch {
            when (val response = getAllUserUserCase.invoke()) {
                is NetworkState.Success -> {
                    _getUser.postValue(response.data!!)
                }
                is NetworkState.Error -> {
                    if (response.response.code() == 401) {
                    } else {
                    }
                }

            }
        }
        /*var result = getAllUserUserCase.invoke()
        if (result.isNotEmpty()) {
            _getUser.postValue(result)
        }*/
    }
}