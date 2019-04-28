package com.ar4i.durak.app.di.modules

import android.content.Context
import com.ar4i.durak.data.db.DbHelper
import com.ar4i.durak.data.db.dao.GamesDao
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

    @Provides
    fun provideGamesDao(dbHelper: DbHelper): GamesDao {
        return GamesDao(dbHelper)
    }
}