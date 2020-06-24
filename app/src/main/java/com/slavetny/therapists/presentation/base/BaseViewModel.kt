package com.slavetny.cryptocurrencyrate.presentation.base

import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    open fun onCreate() {}

    open fun onViewCreated() {}

    open fun onDestroyView() {}

    open fun onDestroy() {}
}