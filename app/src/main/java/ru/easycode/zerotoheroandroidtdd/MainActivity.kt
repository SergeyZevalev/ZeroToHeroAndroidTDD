package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val liveDataWrapper = LiveDataWrapper.Base()
        val repository = Repository.Base()
        val viewModel = MainViewModel(liveDataWrapper, repository)


        val textView = findViewById<TextView>(R.id.titleTextView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        val button = findViewById<Button>(R.id.actionButton)

        viewModel.observe(this) {
            it.show(textView, button, progressBar)
        }

        button.setOnClickListener {
            viewModel.load()
        }
    }
}