package com.ar4i.durak.app.di.modules

import com.ar4i.durak.data.mappers.GamesMapper
import dagger.Module
import dagger.Provides

@Module
class MappersModule {

    @Provides
    fun provideGamesMapper(): GamesMapper {
        return GamesMapper()
    }
}