package com.example.retrofitandroidexample.network

import com.example.mvvmdemo.utils.POST_LOGIN_REQ
import com.example.mvvmdemo.login.model.entity.LoginBodyRequest
import com.example.mvvmdemo.login.model.entity.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Interface for all request response in Application
 */
internal interface APIInterface {


    @POST(POST_LOGIN_REQ)
    fun loginApp(@Body loginReuest : LoginBodyRequest) : Call<LoginResponse>


}