package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData

interface LiveDataWrapper: ProvideLiveData {
    fun update(value: UiState)
    fun save(bundleWrapper: BundleWrapper.Save)

    class Base : LiveDataWrapper {

        private val liveData = SingleLiveEvent<UiState>()
        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun liveData(): LiveData<UiState> {
            return liveData
        }

        override fun save(bundleWrapper: BundleWrapper.Save) {
            bundleWrapper.save(liveData.value!!)
        }

    }
}

interface ProvideLiveData {
    fun liveData(): LiveData<UiState>
}