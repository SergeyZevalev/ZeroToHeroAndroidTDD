package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.core.Core
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.core.ViewModelFactory

class App : Application(), ClearViewModel, ProvideViewModel {

    private lateinit var factory: ViewModelFactory
    private lateinit var provideViewModel: ProvideViewModel
    private lateinit var core: Core

    override fun onCreate() {
        super.onCreate()
        core = Core.Base(this)
        provideViewModel = ProvideViewModel.Base(core)
        factory = ViewModelFactory.Base(provideViewModel)
    }

    override fun clear(viewModelClass: Class<out ViewModel>) =
        factory.clear(viewModelClass)


    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>) =
        factory.viewModel(viewModelClass)

}