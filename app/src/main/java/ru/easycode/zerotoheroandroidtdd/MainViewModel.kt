package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper,
    private val repository: Repository
) : ViewModel() {

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate).launch {
            repository.load()
            liveDataWrapper.update(UiState.ShowData)
        }
    }

    fun provideLiveData(): LiveDataWrapper {
        return liveDataWrapper
    }

}
