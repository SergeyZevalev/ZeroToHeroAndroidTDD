package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ElementBinding

class CommonRecyclerAdapter(
    private val liveDataWrapper: ListLiveDataWrapper
): RecyclerView.Adapter<CommonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        return CommonViewHolder(ElementBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return liveDataWrapper.liveData().value?.size ?: 0
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        val list = liveDataWrapper.liveData().value ?: emptyList()
        holder.bind(list[position])
    }
}

class CommonViewHolder(private val binding: ElementBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(text: CharSequence) {
        binding.elementTextView.text = text
    }
}