package com.ar4i.durak.presentation.game.presenter

import com.ar4i.durak.data.viewmodels.GameVm
import com.ar4i.durak.domain.IGameInteractor
import com.ar4i.durak.presentation.base.presenter.BasePresenter
import com.ar4i.durak.presentation.game.views.GameView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.sql.Timestamp
import javax.inject.Inject

class GamePresenter : BasePresenter<GameView> {

    @Inject
    constructor(gameInteractor: IGameInteractor) {
        this.gameInteractor = gameInteractor
        gameStartTime = Timestamp(System.currentTimeMillis()).getTime()
    }

    //==========================================start Fields============================================================

    private var gameInteractor: IGameInteractor

    private var gameStartTime: Long = 0
    private var gameEndTime: Long = 0
    private var playersNumber: Int = 0
    private var isWin: Boolean = false

    //-------------------------------------------end Fields-------------------------------------------------------------


    //==========================================start implements BasePresenter<GameView>================================

    override fun attachView(v: GameView?) {
        super.attachView(v)
    }

    //-------------------------------------------end implements BasePresenter<GameView>---------------------------------


    // region========================================start Private methods==============================================

    private fun saveGameState(gameVm: GameVm): Unit {
        track(
            gameInteractor.insertGame(gameVm)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { getView()?.showMessage("OK") },
                    { error -> getView()?.showMessage(error.message!!) }
                )
        )
    }

    // endregion-------------------------------------start Private methods----------------------------------------------
}