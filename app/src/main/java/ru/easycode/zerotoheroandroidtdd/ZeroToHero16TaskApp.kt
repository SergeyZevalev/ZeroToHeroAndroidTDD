package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class ZeroToHero16TaskApp : Application(), ProvideViewModel {

    private val coreLiveData = LiveDataWrapper.Base()
    override fun viewModel(): MainViewModel {
        return MainViewModel(coreLiveData, Repository.Base())
    }
}

interface ProvideViewModel {

    fun viewModel() : MainViewModel
}