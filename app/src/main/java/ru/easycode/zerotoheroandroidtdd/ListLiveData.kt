package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.MutableLiveData

interface ListLiveData {

    fun getList(): List<String>
    fun update(item: String)

    class Base : ListLiveData {

        private val liveData = MutableLiveData<MutableList<String>>()
        override fun getList(): List<String> {
            return liveData.value ?: emptyList()
        }

        override fun update(item: String) {
            val list = liveData.value ?: mutableListOf()
            list.add(item)
            liveData.value = list
        }


    }
}