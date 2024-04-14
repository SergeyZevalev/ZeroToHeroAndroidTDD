package ru.easycode.zerotoheroandroidtdd.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.BundleWrapper
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel

class ListFragment(
    resId: Int = R.layout.list_fragment
) : Fragment(resId), ProvideViewModel {

    private lateinit var viewModel: ListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModel(ListViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addButton = view.findViewById<FloatingActionButton>(R.id.addButton)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = CommonListRecyclerAdapter(viewModel.provideListWrapper())
        recyclerView.adapter = adapter

        addButton.setOnClickListener{
            viewModel.create()
        }

        if (savedInstanceState != null) viewModel.restore(BundleWrapper.Base(savedInstanceState))

        viewModel.provideListWrapper().liveData().observe(viewLifecycleOwner){
            adapter.update()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.save(BundleWrapper.Base(outState))
    }

    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>) =
        (activity as ProvideViewModel).viewModel(viewModelClass)

}