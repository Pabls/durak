package com.ar4i.durak.app.di.modules

import android.content.Context
import com.ar4i.durak.app.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApplication(): Context = app
}