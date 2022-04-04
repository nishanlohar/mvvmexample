package com.example.mvvmdemo.network

interface CallbackResponse<T> {

    fun onSuccess(successData: T)

    fun onFailure(failureData: T)
}