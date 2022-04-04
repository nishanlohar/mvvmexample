package com.example.mvvmdemo.login.model

import android.content.Context
import android.widget.Toast
import com.example.mvvmdemo.login.model.entity.LoginBodyRequest
import com.example.mvvmdemo.login.model.entity.LoginResponse
import com.example.mvvmdemo.network.APIClient
import com.example.mvvmdemo.network.CallbackResponse
import com.example.mvvmdemo.utils.isNetworkAvailable
import com.example.retrofitandroidexample.network.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Repository Class for Login to fetch data from Server or Local Database
 */
class LoginRepository(var context: Context) {

    suspend fun loginWithEmailAndPassword(
        email: String?,
        password: String?,
        callBackResponse: CallbackResponse<LoginResponse?>
    ) {

        if (isNetworkAvailable(context)) {
            var loginRequest = LoginBodyRequest(email, password)
            val request = APIClient.buildService(APIInterface::class.java)
            val call = request.loginApp(loginRequest)

            call.enqueue(object : Callback<LoginResponse> {

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    callBackResponse.onSuccess(response.body()) // Callback Line to passback to ViewModel

                }

                override fun onFailure(call: Call<LoginResponse>?, t: Throwable) {
                    //   callBackResponse.onFailure(t)
                }

            })

        } else {
            Toast.makeText(
                context,
                " Network Not Available , Please check internet Connection",
                Toast.LENGTH_LONG
            ).show()

        }


    }


}