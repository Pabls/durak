package com.ar4i.durak.presentation.start.presenter

import com.ar4i.durak.presentation.base.presenter.BasePresenter
import com.ar4i.durak.presentation.start.views.StartView

class StartPresenter : BasePresenter<StartView>() {

    override fun attachView(v: StartView?) {
        super.attachView(v)

        track(getView()!!.onShowStatisticsButtonClick()
            .subscribe { getView()!!.navigateToStatisticsActivity() })

        track(getView()!!.onStartGameButtonClick()
            .subscribe { getView()!!.navigateToNewGameActivity() })

    }
}