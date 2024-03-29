package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface Count {

    fun increment(number: String) : UiState
    class Base(private val step: Int, private val max: Int) : Count {

        init {
            if (step < 1) throw IllegalStateException("step should be positive, but was $step")
            if (max < 1) throw IllegalStateException("max should be positive, but was $max")
            if (max < step) throw IllegalStateException("max should be more than step")
        }
        override fun increment(number: String): UiState {
            val result = number.toInt() + step
            return if ((max - result) >= step) UiState.Base(result.toString())
            else UiState.Max(result.toString())
        }

    }
}

interface UiState: Serializable{

    fun show(textView: TextView, button: Button)
    data class Base(private val text: String): UiState {
        override fun show(textView: TextView, button: Button) {
            textView.text = text
        }
    }

    data class Max(private val text: String): UiState {
        override fun show(textView: TextView, button: Button) {
            textView.text = text
            button.isEnabled = false
        }
    }
}