package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App : Application() {

    private val viewModel = MainViewModel(
        LiveDataWrapper.Base(), Repository.Base()
    )
    fun viewModel() = viewModel
}