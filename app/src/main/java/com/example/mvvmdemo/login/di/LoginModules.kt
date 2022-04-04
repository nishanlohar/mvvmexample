package com.example.mvvmdemo.login.di

import com.example.mvvmdemo.login.model.LoginRepository
import com.example.mvvmdemo.login.viewmodel.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModules = module {

    viewModel {
        LoginViewModel(loginRepository = get())
    }

    single {
        LoginRepository(context = androidContext())
    }
}

