package com.ar4i.durak.app

import android.app.Application
import com.ar4i.durak.app.di.components.AppComponent
import com.ar4i.durak.app.di.components.DaggerAppComponent
import javax.inject.Singleton

@Singleton
class App : Application() {

    companion object {
        val appComponent: AppComponent by lazy {
            DaggerAppComponent
                .builder()
                .build()
        }
    }

    override fun onCreate() {
        appComponent.inject(this)
        super.onCreate()
    }
}