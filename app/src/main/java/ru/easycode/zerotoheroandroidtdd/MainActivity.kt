package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var bundleWrapper: BundleWrapper.Mutable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = (application as App).viewModel()

        val textView = findViewById<TextView>(R.id.titleTextView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val button = findViewById<Button>(R.id.actionButton)

        viewModel.liveData().observe(this) {
            it.show(textView, button, progressBar)
        }

        button.setOnClickListener {
            viewModel.load()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        bundleWrapper = BundleWrapper.Base(outState)
        bundleWrapper.save(viewModel.liveData().value!!)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        bundleWrapper = BundleWrapper.Base(savedInstanceState)
        viewModel.restore(bundleWrapper)
    }
}