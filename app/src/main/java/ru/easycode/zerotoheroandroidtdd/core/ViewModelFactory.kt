package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel

interface ViewModelFactory : ProvideViewModel, ClearViewModel {

    class Base(
        private val provideViewModel: ProvideViewModel
    ) : ViewModelFactory {

        private val listViewModels = mutableMapOf<Class<out ViewModel>, ViewModel>()

        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            val viewModel = listViewModels[viewModelClass]
            return if (viewModel == null) {
                provideViewModel.viewModel(viewModelClass).also {
                    listViewModels[viewModelClass] = it
                }
            } else listViewModels[viewModelClass] as T
        }

        override fun clear(viewModelClass: Class<out ViewModel>) {
            listViewModels.remove(viewModelClass)
        }
    }
}