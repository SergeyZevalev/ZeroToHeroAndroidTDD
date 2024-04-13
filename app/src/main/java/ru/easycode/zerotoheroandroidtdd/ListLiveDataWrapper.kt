package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ListLiveDataWrapper: ProvideLiveData {

    fun add(new: CharSequence)
    fun save(bundle: BundleWrapper.Save)
    fun update(list: List<CharSequence>)

    class Base : ListLiveDataWrapper {

        private val liveData = MutableLiveData<List<CharSequence>>()
        override fun add(new: CharSequence) {
            val newList = liveData.value?.toMutableList() ?: mutableListOf()
            newList.add(new)
            liveData.value = newList
        }

        override fun save(bundle: BundleWrapper.Save) {
            bundle.save(liveData.value?.let { ArrayList(it) }!!)
        }

        override fun update(list: List<CharSequence>) {
            liveData.value = list
        }

        override fun liveData(): LiveData<List<CharSequence>> {
            return liveData
        }

    }
}

interface ProvideLiveData{
    fun liveData(): LiveData<List<CharSequence>>
}