package ru.easycode.zerotoheroandroidtdd

import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

interface MainUiState : Serializable{

    fun show(linearLayout: LinearLayout, textView: TextView)

    object Primary : MainUiState {
        override fun show(linearLayout: LinearLayout, textView: TextView) = Unit
    }

    object Removed : MainUiState {
        override fun show(linearLayout: LinearLayout, textView: TextView) =
            linearLayout.removeView(textView)
    }
}