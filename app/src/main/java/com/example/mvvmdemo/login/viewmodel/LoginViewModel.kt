package com.example.mvvmdemo.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdemo.login.model.LoginRepository
import com.example.mvvmdemo.login.model.entity.LoginResponse
import com.example.mvvmdemo.network.CallbackResponse
import com.example.mvvmdemo.network.Event
import kotlinx.coroutines.launch

class LoginViewModel(var loginRepository: LoginRepository) : ViewModel() {

    private val _loginData: MutableLiveData<Event<LoginResponse?>> = MutableLiveData()
    val loginData: LiveData<Event<LoginResponse?>> get() = _loginData

    fun loginWithEmailandPassword(email: String?, password: String?) {

        viewModelScope.launch {

            loginRepository.loginWithEmailAndPassword(
                email,
                password,
                object : CallbackResponse<LoginResponse?> {
                    override fun onSuccess(successData: LoginResponse?) {
                        _loginData.postValue(Event(successData))
                    }

                    override fun onFailure(failureData: LoginResponse?) {

                    }


                })

        }

    }

}