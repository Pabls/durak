package com.ar4i.durak.app

import android.app.Application
import com.ar4i.durak.app.di.components.AppComponent
import com.ar4i.durak.app.di.components.DaggerAppComponent
import com.ar4i.durak.app.di.modules.AppModule
import javax.inject.Singleton

@Singleton
class App : Application() {

    companion object {
        lateinit var context: App
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)
        super.onCreate()
    }
}