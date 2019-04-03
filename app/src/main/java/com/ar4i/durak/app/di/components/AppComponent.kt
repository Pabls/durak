package com.ar4i.durak.app.di.components

import com.ar4i.durak.app.di.modules.DatabaseModule
import com.ar4i.durak.app.di.modules.PresentationModule
import com.ar4i.durak.app.di.modules.RepositoryModule
import com.ar4i.durak.presentation.game.views.GameActivity
import com.ar4i.durak.presentation.start.views.StartActivity
import com.ar4i.durak.presentation.statistics.views.StatisticsActivity
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = arrayOf(
        DatabaseModule::class,
        PresentationModule::class,
        RepositoryModule::class
    )
)
@Singleton
interface AppComponent {
    fun injectStartActivity(startActivity: StartActivity)
    fun injectStatisticsActivity(statisticsActivity: StatisticsActivity)
    fun injectGameActivity(gameActivity: GameActivity)
}