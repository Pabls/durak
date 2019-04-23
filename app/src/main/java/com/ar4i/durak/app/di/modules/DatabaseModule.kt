package com.ar4i.durak.app.di.modules

import android.content.Context
import com.ar4i.durak.data.DbHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    val dbVersion = 1

    @Provides
    @Singleton
    fun provideDBHelper(context: Context): DbHelper {
        return DbHelper(context, dbVersion)
    }
}