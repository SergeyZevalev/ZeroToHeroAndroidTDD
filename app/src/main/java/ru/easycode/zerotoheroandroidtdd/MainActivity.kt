package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.children
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            createTextView(binding.inputEditText.text.toString())
            binding.inputEditText.text?.clear()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val list = binding.contentLayout.children.map { (it as TextView).text.toString() }.toList()
        outState.putStringArrayList("key", ArrayList(list))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val list = savedInstanceState.getStringArrayList("key")
        list?.forEach { it ->
            createTextView(it)
        }
    }

    fun createTextView(text: String){
        val view = TextView(this)
        view.text = text
        binding.contentLayout.addView(view)
    }

}