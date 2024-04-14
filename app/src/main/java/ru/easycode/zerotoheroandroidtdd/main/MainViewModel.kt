package ru.easycode.zerotoheroandroidtdd.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.list.ListScreen

class MainViewModel(
    private val navigation: Navigation.Mutable
) : ViewModel(), LiveDataWrapper.Observe<Screen>, Navigation.Update {

    fun init(firstRun: Boolean) {
        if (firstRun) navigation.update(ListScreen)
    }

    override fun liveData(): LiveData<Screen> {
        return navigation.liveData()
    }

    override fun update(value: Screen){
        navigation.update(value)
    }
}