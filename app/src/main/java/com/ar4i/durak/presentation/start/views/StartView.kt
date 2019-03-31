package com.ar4i.durak.presentation.start.views

import com.ar4i.durak.presentation.base.views.BaseMvpView
import io.reactivex.Observable

interface StartView: BaseMvpView {
    fun onStartGameButtonClick(): Observable<Boolean>
    fun onShowStatisticsButtonClick(): Observable<Boolean>
    fun navigateToNewGameActivity()
    fun navigateToStatisticsActivity()
}