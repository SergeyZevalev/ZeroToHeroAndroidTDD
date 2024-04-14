package ru.easycode.zerotoheroandroidtdd.core

import ru.easycode.zerotoheroandroidtdd.list.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.main.Navigation

interface Core {

    fun provideMainNavigation() : Navigation.Mutable
    fun provideLiveDataWrapper() : ListLiveDataWrapper.All
    fun provideClearViewModel() : ClearViewModel

    class Base(
        private val clearViewModel: ClearViewModel
    ) : Core {

        private val navigation = Navigation.Base()
        private val liveDataWrapper = ListLiveDataWrapper.Base()
        override fun provideMainNavigation() = navigation
        override fun provideLiveDataWrapper() = liveDataWrapper
        override fun provideClearViewModel() = clearViewModel

    }
}