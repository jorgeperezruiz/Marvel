package com.akudreams.marvel

import android.app.Application
import com.akudreams.marvel.injection.AppComponent

class MarvelApplication : Application() {

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.create(this)
    }

}