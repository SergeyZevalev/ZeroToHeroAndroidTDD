package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

interface MainUiState : Serializable {

    fun show(linearLayout: LinearLayout, textView: TextView, button: Button)

    object Primary : MainUiState {
        override fun show(linearLayout: LinearLayout, textView: TextView, button: Button) = Unit
    }

    object Removed : MainUiState {
        override fun show(linearLayout: LinearLayout, textView: TextView, button: Button) {
            linearLayout.removeView(textView)
            button.isEnabled = false
        }

    }
}