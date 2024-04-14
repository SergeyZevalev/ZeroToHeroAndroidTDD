package ru.easycode.zerotoheroandroidtdd.main

import androidx.fragment.app.FragmentManager
import ru.easycode.zerotoheroandroidtdd.create.CreateFragment
import ru.easycode.zerotoheroandroidtdd.list.ListFragment
import java.io.Serializable

interface Screen : Serializable {

    fun show(fragmentManager: FragmentManager, container: Int)

    object Pop : Screen {
        override fun show(fragmentManager: FragmentManager, container: Int) =
            fragmentManager.popBackStack()
    }

    abstract class Replace : Screen {
        override fun show(fragmentManager: FragmentManager, container: Int) {
            fragmentManager.beginTransaction()
                .replace(container, ListFragment()).commit()
        }
    }

    abstract class BackStack : Screen {
        override fun show(fragmentManager: FragmentManager, container: Int) {
            fragmentManager.beginTransaction()
                .addToBackStack(CreateFragment().javaClass.name)
                .replace(container, CreateFragment()).commit()
        }
    }
}