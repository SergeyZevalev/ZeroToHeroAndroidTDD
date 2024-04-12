package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData

interface LiveDataWrapper {

    interface Save{
        fun save(bundleWrapper: BundleWrapper.Save)
    }

    interface Update{
        fun update(value: UiState)
    }

    interface Mutable: Save, Update, ProvideLiveData

    interface ProvideLiveData{
        fun liveData(): LiveData<UiState>
    }

    class Base() : Mutable {

        private val liveData = SingleLiveEvent<UiState>()
        override fun liveData(): LiveData<UiState> {
            return liveData
        }

        override fun save(bundleWrapper: BundleWrapper.Save) {
            bundleWrapper.save(liveData.value!!)
        }

        override fun update(value: UiState) {
            liveData.value = value
        }

    }
}