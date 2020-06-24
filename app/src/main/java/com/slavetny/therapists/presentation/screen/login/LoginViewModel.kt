package com.slavetny.therapists.presentation.screen.login

import android.content.Context
import com.slavetny.cryptocurrencyrate.presentation.base.BaseViewModel
import com.slavetny.therapists.data.repository.TherapistsRepository

class LoginViewModel(var therapistsRepository: TherapistsRepository) : BaseViewModel() {

    fun onAuthorize(context: Context, email: String, password: String) {
        therapistsRepository.onAuthorize(context, email, password)
    }
}