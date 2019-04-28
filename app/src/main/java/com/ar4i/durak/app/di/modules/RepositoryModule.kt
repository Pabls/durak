package com.ar4i.durak.app.di.modules

import com.ar4i.durak.data.db.dao.GamesDao
import com.ar4i.durak.data.mappers.GamesMapper
import com.ar4i.durak.data.repositories.DatabaseRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideDatabaseRepository(gamesDao: GamesDao, gamesMapper: GamesMapper): DatabaseRepository {
        return DatabaseRepository(gamesDao, gamesMapper)
    }
}