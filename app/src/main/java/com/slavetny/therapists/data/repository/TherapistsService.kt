package com.slavetny.therapists.data.repository

import com.slavetny.cryptocurrencyrate.data.utils.constants.Constants
import com.slavetny.therapists.domain.model.Login
import com.slavetny.therapists.domain.model.Therapist
import com.slavetny.therapists.domain.model.Token
import retrofit2.Call
import retrofit2.http.*

interface TherapistsService {

    @Headers("Content-Type: application/json")
    @POST(Constants.ON_AUTHORIZE)
    fun authorize(@Body body: Login) : Call<Token>

    @Headers("Content-Type: application/json")
    @GET(Constants.GET_LIST_OF_THERAPISTS)
    fun  getTherapistsList(@Header("Authorization") token: String) : Call<List<Therapist>>

}