package ru.easycode.zerotoheroandroidtdd.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ProvideViewModel {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = viewModel(MainViewModel::class.java)

        viewModel.init(savedInstanceState == null)

        viewModel.liveData().observe(this) {
            it.show(supportFragmentManager, R.id.rootFragmentLayout)
        }

    }

    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>) =
        (application as ProvideViewModel).viewModel(viewModelClass)


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(SCREEN_KEY, viewModel.liveData().value)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.update(savedInstanceState.getSerializable(SCREEN_KEY) as Screen)
    }

    companion object {
        private const val SCREEN_KEY = "screen"
    }

}