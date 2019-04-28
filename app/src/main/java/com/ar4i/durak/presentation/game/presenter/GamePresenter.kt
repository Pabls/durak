package com.ar4i.durak.presentation.game.presenter

import com.ar4i.durak.domain.IGameInteractor
import com.ar4i.durak.presentation.base.presenter.BasePresenter
import com.ar4i.durak.presentation.game.views.GameView
import javax.inject.Inject

class GamePresenter : BasePresenter<GameView> {

    @Inject
    constructor(gameInteractor: IGameInteractor) {
        this.gameInteractor = gameInteractor
    }

    //==========================================start Fields============================================================

    var gameInteractor: IGameInteractor

    //-------------------------------------------end Fields-------------------------------------------------------------


    //==========================================start implements BasePresenter<GameView>================================

    override fun attachView(v: GameView?) {
        super.attachView(v)

        if (gameInteractor != null) {
            var g: Int = 0;
        }
    }

    //-------------------------------------------end implements BasePresenter<GameView>---------------------------------
}