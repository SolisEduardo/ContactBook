package com.example.contactbook.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactbook.data.model.UserModelItem
import com.example.contactbook.data.network.NetworkState
import com.example.contactbook.domain.GetAllUserUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetUserViewModel @Inject constructor(private var getAllUserUserCase: GetAllUserUserCase) :
    ViewModel() {


    private var _getUser = MutableLiveData<List<UserModelItem>>()
    val getUser: MutableLiveData<List<UserModelItem>>
        get() = _getUser

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    var job: Job? = null

    fun getAllUser() {
        _isLoading.postValue(true)
        viewModelScope.launch {
            when (val response = getAllUserUserCase.invoke()) {
                is NetworkState.Success -> {
                    _isLoading.postValue(false)
                    _getUser.postValue(response.data!!)
                }
                is NetworkState.Error -> {
                        _isLoading.postValue(true)
                        _errorMessage.postValue(response.response.code().toString())
                }

            }
        }
        /*var result = getAllUserUserCase.invoke()
        if (result.isNotEmpty()) {
            _getUser.postValue(result)
        }*/
    }
    private fun onError(message: String) {
        _errorMessage.value = message
        _isLoading.value = false
    }
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}