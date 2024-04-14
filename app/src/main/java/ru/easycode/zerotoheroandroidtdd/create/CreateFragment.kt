package ru.easycode.zerotoheroandroidtdd.create

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel

class CreateFragment(
    resId: Int = R.layout.create_fragment
) : Fragment(resId), ProvideViewModel {

    private lateinit var viewModel: CreateViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModel(CreateViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputText = view.findViewById<TextInputEditText>(R.id.inputEditText)
        val createButton = view.findViewById<Button>(R.id.createButton)

        createButton.setOnClickListener {
            viewModel.add(inputText.text.toString())
            inputText.text?.clear()
        }

        inputText.addTextChangedListener {
            createButton.isEnabled = inputText.text.toString().length > 2
        }

    }

    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>) =
        (activity as ProvideViewModel).viewModel(viewModelClass)

}