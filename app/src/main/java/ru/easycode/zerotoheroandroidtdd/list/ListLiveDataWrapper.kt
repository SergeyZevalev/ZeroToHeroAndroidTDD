package ru.easycode.zerotoheroandroidtdd.list

import androidx.recyclerview.widget.DiffUtil
import ru.easycode.zerotoheroandroidtdd.core.BundleWrapper
import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper

interface ListLiveDataWrapper {

    interface Add {
        fun add(source: CharSequence)
    }

    interface Save {
        fun save(bundleWrapper: BundleWrapper.Save)
    }

    interface UpdateList : LiveDataWrapper.Update<List<CharSequence>>

    interface ObserveList : LiveDataWrapper.Observe<List<CharSequence>>

    interface DiffResult {

        fun getDiffResult(): DiffUtil.DiffResult
    }

    interface Mutable : UpdateList, ObserveList, Save

    interface All : Mutable, Add, DiffResult

    class Base : LiveDataWrapper.Abstract<List<CharSequence>>(), All {

        private lateinit var diffResult: DiffUtil.DiffResult
        override fun add(source: CharSequence) {
            val oldList = liveData.value ?: emptyList()
            val newList = liveData.value?.toMutableList() ?: mutableListOf()
            newList.add(source)
            val callback = CommonDiffUtilCallback(oldList, newList)
            diffResult = DiffUtil.calculateDiff(callback)
            update(newList)
        }

        override fun save(bundleWrapper: BundleWrapper.Save) =
            bundleWrapper.save(ArrayList(liveData.value ?: emptyList()))

        override fun getDiffResult() = diffResult

    }

}