package com.ar4i.durak.app.di.modules

import com.ar4i.durak.domain.GameInteractor
import com.ar4i.durak.presentation.game.presenter.GamePresenter
import com.ar4i.durak.presentation.start.presenter.StartPresenter
import com.ar4i.durak.presentation.statistics.presenter.StatisticsPresenter
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun provideStartPresenter(): StartPresenter {
        return StartPresenter()
    }

    @Provides
    fun provideStatisticsPresenter(): StatisticsPresenter {
        return StatisticsPresenter()
    }

    @Provides
    fun provideGamePresenter(gameInteractor: GameInteractor): GamePresenter {
        return GamePresenter(gameInteractor)
    }
}