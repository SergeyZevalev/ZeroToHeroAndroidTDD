package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.create.CreateViewModel
import ru.easycode.zerotoheroandroidtdd.list.ListViewModel
import ru.easycode.zerotoheroandroidtdd.main.MainViewModel

interface ProvideViewModel {

    fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T

    class Base(
        private val core: Core
    ) : ProvideViewModel {
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return when (viewModelClass) {
                MainViewModel::class.java -> MainViewModel(core.provideMainNavigation())
                ListViewModel::class.java -> ListViewModel(
                    core.provideLiveDataWrapper(), core.provideMainNavigation()
                )
                CreateViewModel::class.java -> CreateViewModel(
                    core.provideLiveDataWrapper(), core. provideMainNavigation(), core.provideClearViewModel()
                )
                else -> throw IllegalStateException("Unknown class $viewModelClass!")
            } as T
        }

    }
}