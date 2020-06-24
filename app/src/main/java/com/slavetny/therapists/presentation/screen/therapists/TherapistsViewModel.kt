package com.slavetny.therapists.presentation.screen.therapists

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.slavetny.cryptocurrencyrate.presentation.base.BaseViewModel
import com.slavetny.therapists.TherapistsApp
import com.slavetny.therapists.data.repository.TherapistsRepository
import com.slavetny.therapists.domain.model.Therapist

class TherapistsViewModel(context: Context, therapistsRepository: TherapistsRepository) : BaseViewModel() {

    private var _therapistsList: MutableLiveData<List<Therapist>> = MutableLiveData()
    val therapistsList: LiveData<List<Therapist>> get() = _therapistsList

    init {
        _therapistsList = therapistsRepository.getTherapistsList(TherapistsApp.getToken(context)!!)
    }
}