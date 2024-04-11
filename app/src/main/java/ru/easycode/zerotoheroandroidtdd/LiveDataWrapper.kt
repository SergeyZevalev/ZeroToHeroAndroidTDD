package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

interface LiveDataWrapper: ObserverImpl {

    fun update(value: UiState)

    fun liveData(): LiveData<UiState>

    class Base() : LiveDataWrapper {

        private var list = MutableLiveData<UiState>()
        override fun update(value: UiState) {
            list.value = value
        }

        override fun liveData(): LiveData<UiState> {
            return list
        }

        override fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<UiState>) {
            list.observe(lifecycleOwner, observer)
        }

    }
}