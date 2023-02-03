package br.com.mobile.thedictionary

import android.app.Application
import br.com.mobile.thedictionary.network.ApiModule
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication : Application() {

    companion object{
        private lateinit var newInstance: HiltApplication

        val apiService by lazy { ApiModule().services() }
    }

    override fun onCreate() {
        super.onCreate()
       newInstance = this
    }
}