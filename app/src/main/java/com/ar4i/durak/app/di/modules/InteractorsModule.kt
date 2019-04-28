package com.ar4i.durak.app.di.modules

import com.ar4i.durak.data.repositories.DatabaseRepository
import com.ar4i.durak.domain.GameInteractor
import dagger.Module
import dagger.Provides

@Module
class InteractorsModule {

    @Provides
    fun provideGameInteractor(databaseRepository: DatabaseRepository): GameInteractor {
        return GameInteractor(databaseRepository)
    }
}