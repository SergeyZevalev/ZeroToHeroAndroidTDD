package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App: Application() {

    val list = mutableListOf<String>()

    fun provideLiveData() = list
}