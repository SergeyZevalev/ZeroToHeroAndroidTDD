package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface Count {

    fun increment(number: String): UiState
    fun decrement(number: String) : UiState
    fun initial(number: String) : UiState
    class Base(
        private val step: Int,
        private val max: Int,
        private val min: Int) : Count {

        init {
            if (step < 1)
                throw IllegalStateException("step should be positive, but was $step")
            if (max < 1)
                throw IllegalStateException("max should be positive, but was $max")
            if (max < step)
                throw IllegalStateException("max should be more than step")
            if (max < min)
                throw IllegalStateException("max should be more than min")
        }
        override fun increment(number: String): UiState {
            val resultMax = number.toInt() + step
            return if ((max - resultMax) >= step) UiState.Base(resultMax.toString())
            else UiState.Max(resultMax.toString())
        }

        override fun decrement(number: String): UiState {
            val resultMin = number.toInt() - step
            return if ((min + resultMin) >= step) UiState.Base(resultMin.toString())
            else UiState.Min(resultMin.toString())
        }

        override fun initial(number: String): UiState {
            val numberInt = number.toInt()
            return if ((max - numberInt) < step) UiState.Max(number)
            else if ((min + numberInt) < step) UiState.Min(number)
            else UiState.Base(number)
        }

    }
}

interface UiState: Serializable {

    fun show(textView: TextView, incrementButton: Button, decrementButton: Button)
    data class Base(private val text: String) : UiState {
        override fun show(textView: TextView, incrementButton: Button, decrementButton: Button) {
            textView.text = text
            incrementButton.isEnabled = true
            decrementButton.isEnabled = true
        }
    }

    data class Max(private val text: String) : UiState {
        override fun show(textView: TextView, incrementButton: Button, decrementButton: Button) {
            textView.text = text
            incrementButton.isEnabled = false
            decrementButton.isEnabled = true
        }
    }

    data class Min(private val text: String) : UiState {
        override fun show(textView: TextView, incrementButton: Button, decrementButton: Button) {
            textView.text = text
            decrementButton.isEnabled = false
            incrementButton.isEnabled = true
        }
    }
}