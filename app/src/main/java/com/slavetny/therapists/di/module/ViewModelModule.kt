package com.slavetny.therapists.di.module

import com.slavetny.therapists.data.repository.TherapistsRepository
import com.slavetny.therapists.presentation.screen.login.LoginFragment
import com.slavetny.therapists.presentation.screen.login.LoginViewModel
import com.slavetny.therapists.presentation.screen.therapists.TherapistsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { TherapistsViewModel(get(), get()) }
    single { TherapistsRepository(get()) }

    single { LoginFragment() }
}