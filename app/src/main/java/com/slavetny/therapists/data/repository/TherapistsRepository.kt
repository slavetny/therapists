package com.slavetny.therapists.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.slavetny.therapists.TherapistsApp
import com.slavetny.therapists.domain.model.Login
import com.slavetny.therapists.domain.model.Therapist
import com.slavetny.therapists.domain.model.Token
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TherapistsRepository(private val therapistsService: TherapistsService) {

    private val therapistsList: MutableLiveData<List<Therapist>> = MutableLiveData()

    fun onAuthorize(context: Context, email: String, password: String) {
        val login = Login(password, true, email)

        val therapistsService: Call<Token> = therapistsService.authorize(login)

        therapistsService.enqueue(object: Callback<Token> {
            override fun onFailure(call: Call<Token>, t: Throwable) {
                Log.d("abc", t.message)
            }

            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                TherapistsApp.setToken(context, response.body()!!.id)
            }
        })
    }

    fun getTherapistsList(token: String): MutableLiveData<List<Therapist>> {
        val therapistsService: Call<List<Therapist>> = therapistsService.getTherapistsList("Bearer $token")

        therapistsService.enqueue(object: Callback<List<Therapist>> {
            override fun onFailure(call: Call<List<Therapist>>, t: Throwable) {
                Log.d("abc", t.message)
            }

            override fun onResponse(call: Call<List<Therapist>>, response: Response<List<Therapist>>) {
                therapistsList.value = response.body()
            }
        })

        return therapistsList
    }
}