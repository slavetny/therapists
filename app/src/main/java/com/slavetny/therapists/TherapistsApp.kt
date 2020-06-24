package com.slavetny.therapists

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.slavetny.therapists.di.module.networkModule
import com.slavetny.therapists.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TherapistsApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TherapistsApp)
            androidLogger()
            modules(
                listOf (viewModelModule, networkModule)
            )
        }
    }

    companion object {
        fun setToken(context: Context, token: String) {
            val sPref = context.getSharedPreferences("ACCESS_TOKEN", Context.MODE_PRIVATE)

            val ed: SharedPreferences.Editor? = sPref?.edit()

            ed?.putString("ACCESS_TOKEN", token)
            ed?.commit()
        }

        fun getToken(context: Context): String? {
            val sPref = context.getSharedPreferences("ACCESS_TOKEN", Context.MODE_PRIVATE)

            val token = sPref?.getString("ACCESS_TOKEN", "empty")

            return token
        }
    }
}