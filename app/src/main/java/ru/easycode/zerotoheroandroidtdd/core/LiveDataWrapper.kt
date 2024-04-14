package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.LiveData

interface LiveDataWrapper {

    interface Update<T : Any> {
        fun update(value: T)
    }

    interface Observe<T : Any> {
        fun liveData(): LiveData<T>
    }

    interface Mutable<T : Any> : Update<T>, Observe<T>

    abstract class Abstract<T : Any> : Mutable<T> {

        protected val liveData = SingleLiveEvent<T>()

        override fun update(value: T) {
            liveData.value = value
        }

        override fun liveData() = liveData

    }
}