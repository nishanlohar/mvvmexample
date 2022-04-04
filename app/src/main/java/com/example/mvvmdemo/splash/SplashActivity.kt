package com.example.mvvmdemo.splash


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmdemo.R
import com.example.mvvmdemo.login.view.LoginActivity


/**
 * This is Splash Activity
 */
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val i = Intent(
                this,
                LoginActivity::class.java
            ) //Intent is used to switch from one activity to another.
            startActivity(i) //invoke the Login  Activity.
            finish() // Finishes the Splash Activity

        }, 5000)
    }
}