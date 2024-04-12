package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable{

    fun show(textView: TextView, progressBar: ProgressBar, button: Button)

    object ShowProgress : UiState {
        override fun show(textView: TextView, progressBar: ProgressBar, button: Button) {
            textView.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
            button.isEnabled = false
        }
    }
    data class ShowData(
        private val text: String
    ) : UiState {
        override fun show(textView: TextView, progressBar: ProgressBar, button: Button) {
            textView.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            button.isEnabled = true
            textView.text = text
        }

    }
}