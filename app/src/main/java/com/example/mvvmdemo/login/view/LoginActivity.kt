package com.example.mvvmdemo.login.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.mvvmdemo.R
import com.example.mvvmdemo.login.di.loginModules
import com.example.mvvmdemo.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.context.loadKoinModules

/**
 * This Activity is used to demonstrate Login View to End User
 */
class LoginActivity : AppCompatActivity() {

    lateinit var loginBtn: Button
    lateinit var emailId: TextView
    lateinit var password: TextView
    lateinit var progressBar: ProgressBar

    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loadKoinModules(loginModules)

        loginBtn = findViewById(R.id.loginBtn)
        emailId = findViewById(R.id.emailIdEdtTxt)
        password = findViewById(R.id.passwordEdtTxt)
        progressBar = findViewById(R.id.progressBar)

        loginViewModel = getViewModel()
        initObserver()

        loginBtn.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            loginViewModel.loginWithEmailandPassword(
                emailId.text.toString(),
                password.text.toString()
            )
        }

    }

    /**
     * Observer function to watch Livedata from ViewModel
     */
    private fun initObserver() {

        loginViewModel.loginData.observe(this, Observer { event ->
            event.getContentIfNotHandled()?.let { response ->
                progressBar.visibility = View.GONE
                if (response != null) {
                    Toast.makeText(this, " SUCCESSFULL ", Toast.LENGTH_LONG).show()
                    // MAIN ACTIVITY
                }


            }

        })
    }
}