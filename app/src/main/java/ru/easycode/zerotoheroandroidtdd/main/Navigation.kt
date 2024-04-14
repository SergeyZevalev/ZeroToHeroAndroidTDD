package ru.easycode.zerotoheroandroidtdd.main

import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper

interface Navigation {

    interface Update : LiveDataWrapper.Update<Screen>
    interface Observe: LiveDataWrapper.Observe<Screen>
    interface Mutable : Update, Observe
    class Base : LiveDataWrapper.Abstract<Screen>(), Mutable
}