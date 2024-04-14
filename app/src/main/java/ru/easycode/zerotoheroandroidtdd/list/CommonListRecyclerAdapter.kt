package ru.easycode.zerotoheroandroidtdd.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ElementViewBinding

class CommonListRecyclerAdapter(
    private val listLiveDataWrapper: ListLiveDataWrapper.All
) : RecyclerView.Adapter<CommonListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CommonListViewHolder(ElementViewBinding.inflate(LayoutInflater.from(parent.context)))

    override fun getItemCount() =
        listLiveDataWrapper.liveData().value?.size ?: 0

    override fun onBindViewHolder(holder: CommonListViewHolder, position: Int) =
        holder.bind(listLiveDataWrapper.liveData().value?.get(position).toString())

    fun update() = listLiveDataWrapper.getDiffResult().dispatchUpdatesTo(this)

}

class CommonListViewHolder(private val binding: ElementViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(text: String) {
        binding.elementTextView.text = text
    }
}