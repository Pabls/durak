package com.ar4i.durak.app

import android.app.Application
import com.ar4i.durak.app.di.components.AppComponent
import com.ar4i.durak.app.di.components.DaggerAppComponent

class App : Application() {

    //==========================================start Fields==============================================

    private lateinit var appComponent: AppComponent

    //-------------------------------------------end Fields-----------------------------------------------


    //==========================================start Lifecycle==============================================

    override fun onCreate() {
        super.onCreate()

        this.appComponent = DaggerAppComponent.create()
    }

    //-------------------------------------------end Lifecycle-----------------------------------------------


    //==========================================start Public Methods==============================================

    open fun getComponent(): AppComponent = this.appComponent

    //-------------------------------------------end Public Methods-----------------------------------------------


}