package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App: Application() {

    private val viewModel = MainViewModel(ListLiveDataWrapper.Base())

    fun viewModel() = viewModel
}