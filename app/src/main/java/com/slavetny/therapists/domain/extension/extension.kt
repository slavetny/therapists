package com.slavetny.therapists.domain.extension

import android.util.Patterns
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun String.isEmail(): Boolean {
    return this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isPassword(): Boolean {
    return this.isNotEmpty() && this.length >= 4
}

inline fun <T> LiveData<T>.observeNotNull(
    owner: LifecycleOwner,
    crossinline observer: (T) -> Unit
) {
    observe(owner, Observer { it?.let { observer.invoke(it) } })
}

fun ViewGroup.inflate(layoutRes: Int) =
    LayoutInflater.from(context).inflate(layoutRes,this, false)