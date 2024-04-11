package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.google.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service: SimpleService = retrofit.create(SimpleService::class.java)
    val url = "https://raw.githubusercontent.com/JohnnySC/ZeroToHeroAndroidTDD/task/018-clouddatasource/app/sampleresponse.json"

    private val viewModel = MainViewModel(LiveDataWrapper.Base(), Repository.Base(service, url))
    fun viewModel() = viewModel
}